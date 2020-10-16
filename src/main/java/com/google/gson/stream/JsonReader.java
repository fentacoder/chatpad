package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader implements Closeable {
  private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
  
  private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
  
  private static final int NUMBER_CHAR_DECIMAL = 3;
  
  private static final int NUMBER_CHAR_DIGIT = 2;
  
  private static final int NUMBER_CHAR_EXP_DIGIT = 7;
  
  private static final int NUMBER_CHAR_EXP_E = 5;
  
  private static final int NUMBER_CHAR_EXP_SIGN = 6;
  
  private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
  
  private static final int NUMBER_CHAR_NONE = 0;
  
  private static final int NUMBER_CHAR_SIGN = 1;
  
  private static final int PEEKED_BEGIN_ARRAY = 3;
  
  private static final int PEEKED_BEGIN_OBJECT = 1;
  
  private static final int PEEKED_BUFFERED = 11;
  
  private static final int PEEKED_DOUBLE_QUOTED = 9;
  
  private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
  
  private static final int PEEKED_END_ARRAY = 4;
  
  private static final int PEEKED_END_OBJECT = 2;
  
  private static final int PEEKED_EOF = 17;
  
  private static final int PEEKED_FALSE = 6;
  
  private static final int PEEKED_LONG = 15;
  
  private static final int PEEKED_NONE = 0;
  
  private static final int PEEKED_NULL = 7;
  
  private static final int PEEKED_NUMBER = 16;
  
  private static final int PEEKED_SINGLE_QUOTED = 8;
  
  private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
  
  private static final int PEEKED_TRUE = 5;
  
  private static final int PEEKED_UNQUOTED = 10;
  
  private static final int PEEKED_UNQUOTED_NAME = 14;
  
  private final char[] buffer = new char[1024];
  
  private final Reader in;
  
  private boolean lenient = false;
  
  private int limit = 0;
  
  private int lineNumber = 0;
  
  private int lineStart = 0;
  
  private int[] pathIndices;
  
  private String[] pathNames;
  
  int peeked = 0;
  
  private long peekedLong;
  
  private int peekedNumberLength;
  
  private String peekedString;
  
  private int pos = 0;
  
  private int[] stack = new int[32];
  
  private int stackSize = 0;
  
  static {
    JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
        public void promoteNameToValue(JsonReader param1JsonReader) throws IOException {
          if (param1JsonReader instanceof JsonTreeReader) {
            ((JsonTreeReader)param1JsonReader).promoteNameToValue();
            return;
          } 
          int i = param1JsonReader.peeked;
          int j = i;
          if (i == 0)
            j = param1JsonReader.doPeek(); 
          if (j == 13) {
            param1JsonReader.peeked = 9;
          } else if (j == 12) {
            param1JsonReader.peeked = 8;
          } else {
            if (j == 14) {
              param1JsonReader.peeked = 10;
              return;
            } 
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a name but was ");
            stringBuilder.append(param1JsonReader.peek());
            stringBuilder.append(param1JsonReader.locationString());
            throw new IllegalStateException(stringBuilder.toString());
          } 
        }
      };
  }
  
  public JsonReader(Reader paramReader) {
    int[] arrayOfInt = this.stack;
    int i = this.stackSize;
    this.stackSize = i + 1;
    arrayOfInt[i] = 6;
    this.pathNames = new String[32];
    this.pathIndices = new int[32];
    if (paramReader != null) {
      this.in = paramReader;
      return;
    } 
    throw new NullPointerException("in == null");
  }
  
  private void checkLenient() throws IOException {
    if (this.lenient)
      return; 
    throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
  }
  
  private void consumeNonExecutePrefix() throws IOException {
    nextNonWhitespace(true);
    int i = --this.pos;
    char[] arrayOfChar = NON_EXECUTE_PREFIX;
    if (i + arrayOfChar.length > this.limit && !fillBuffer(arrayOfChar.length))
      return; 
    i = 0;
    while (true) {
      arrayOfChar = NON_EXECUTE_PREFIX;
      if (i < arrayOfChar.length) {
        if (this.buffer[this.pos + i] != arrayOfChar[i])
          return; 
        i++;
        continue;
      } 
      this.pos += arrayOfChar.length;
      return;
    } 
  }
  
  private boolean fillBuffer(int paramInt) throws IOException {
    char[] arrayOfChar = this.buffer;
    int i = this.lineStart;
    int j = this.pos;
    this.lineStart = i - j;
    i = this.limit;
    if (i != j) {
      this.limit = i - j;
      System.arraycopy(arrayOfChar, j, arrayOfChar, 0, this.limit);
    } else {
      this.limit = 0;
    } 
    this.pos = 0;
    while (true) {
      Reader reader = this.in;
      j = this.limit;
      j = reader.read(arrayOfChar, j, arrayOfChar.length - j);
      if (j != -1) {
        this.limit += j;
        j = paramInt;
        if (this.lineNumber == 0) {
          i = this.lineStart;
          j = paramInt;
          if (i == 0) {
            j = paramInt;
            if (this.limit > 0) {
              j = paramInt;
              if (arrayOfChar[0] == '﻿') {
                this.pos++;
                this.lineStart = i + 1;
                j = paramInt + 1;
              } 
            } 
          } 
        } 
        paramInt = j;
        if (this.limit >= j)
          return true; 
        continue;
      } 
      return false;
    } 
  }
  
  private boolean isLiteral(char paramChar) throws IOException {
    if (paramChar != '\t' && paramChar != '\n' && paramChar != '\f' && paramChar != '\r' && paramChar != ' ')
      if (paramChar != '#') {
        if (paramChar != ',')
          if (paramChar != '/' && paramChar != '=') {
            if (paramChar != '{' && paramChar != '}' && paramChar != ':')
              if (paramChar != ';') {
                switch (paramChar) {
                  default:
                    return true;
                  case '\\':
                    checkLenient();
                    break;
                  case '[':
                  case ']':
                    break;
                } 
                return false;
              }  
            return false;
          }  
        return false;
      }  
    return false;
  }
  
  private String locationString() {
    int i = this.lineNumber;
    int j = this.pos;
    int k = this.lineStart;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" at line ");
    stringBuilder.append(i + 1);
    stringBuilder.append(" column ");
    stringBuilder.append(j - k + 1);
    stringBuilder.append(" path ");
    stringBuilder.append(getPath());
    return stringBuilder.toString();
  }
  
  private int nextNonWhitespace(boolean paramBoolean) throws IOException {
    char[] arrayOfChar = this.buffer;
    int i = this.pos;
    int j = this.limit;
    while (true) {
      StringBuilder stringBuilder1;
      int m = i;
      int n = j;
      if (i == j) {
        this.pos = i;
        if (!fillBuffer(1)) {
          if (!paramBoolean)
            return -1; 
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append("End of input");
          stringBuilder1.append(locationString());
          throw new EOFException(stringBuilder1.toString());
        } 
        m = this.pos;
        n = this.limit;
      } 
      i = m + 1;
      StringBuilder stringBuilder2 = stringBuilder1[m];
      if (stringBuilder2 == 10) {
        this.lineNumber++;
        this.lineStart = i;
      } else if (stringBuilder2 != 32 && stringBuilder2 != 13 && stringBuilder2 != 9) {
        int i1;
        int i2;
        if (stringBuilder2 == 47) {
          this.pos = i;
          if (i == n) {
            this.pos--;
            boolean bool = fillBuffer(2);
            this.pos++;
            if (!bool)
              return stringBuilder2; 
          } 
          checkLenient();
          n = this.pos;
          StringBuilder stringBuilder = stringBuilder1[n];
          if (stringBuilder != 42) {
            if (stringBuilder != 47)
              return stringBuilder2; 
            this.pos = n + 1;
            skipToEndOfLine();
            i1 = this.pos;
            i2 = this.limit;
            continue;
          } 
          this.pos = n + 1;
          if (skipTo("*/")) {
            i1 = this.pos + 2;
            i2 = this.limit;
            continue;
          } 
          throw syntaxError("Unterminated comment");
        } 
        if (i2 == 35) {
          this.pos = i1;
          checkLenient();
          skipToEndOfLine();
          i1 = this.pos;
          i2 = this.limit;
          continue;
        } 
        this.pos = i1;
        return i2;
      } 
      int k = n;
    } 
  }
  
  private String nextQuotedValue(char paramChar) throws IOException {
    char[] arrayOfChar = this.buffer;
    StringBuilder stringBuilder = new StringBuilder();
    while (true) {
      int i = this.pos;
      int j = this.limit;
      label21: while (true) {
        int k = i;
        while (true) {
          int m = k;
          if (m < j) {
            k = m + 1;
            m = arrayOfChar[m];
            if (m == paramChar) {
              this.pos = k;
              stringBuilder.append(arrayOfChar, i, k - i - 1);
              return stringBuilder.toString();
            } 
            if (m == 92) {
              this.pos = k;
              stringBuilder.append(arrayOfChar, i, k - i - 1);
              stringBuilder.append(readEscapeCharacter());
              i = this.pos;
              j = this.limit;
              continue label21;
            } 
            if (m == 10) {
              this.lineNumber++;
              this.lineStart = k;
            } 
            continue;
          } 
          stringBuilder.append(arrayOfChar, i, m - i);
          this.pos = m;
          break;
        } 
        break;
      } 
      if (fillBuffer(1))
        continue; 
      throw syntaxError("Unterminated string");
    } 
  }
  
  private String nextUnquotedValue() throws IOException {
    byte b;
    StringBuilder stringBuilder2;
    String str;
    boolean bool = false;
    StringBuilder stringBuilder1 = null;
    while (true) {
      b = 0;
      while (true) {
        int i = this.pos;
        if (i + b < this.limit) {
          i = this.buffer[i + b];
          if (i != 9 && i != 10 && i != 12 && i != 13 && i != 32)
            if (i != 35) {
              if (i != 44)
                if (i != 47 && i != 61) {
                  if (i != 123 && i != 125 && i != 58)
                    if (i != 59) {
                      switch (i) {
                        default:
                          b++;
                          continue;
                        case 92:
                          checkLenient();
                          break;
                        case 91:
                        case 93:
                          break;
                      } 
                    } else {
                    
                    }  
                } else {
                
                }  
            } else {
            
            }  
        } else if (b < this.buffer.length) {
          if (fillBuffer(b + 1))
            continue; 
        } else {
          StringBuilder stringBuilder = stringBuilder1;
          if (stringBuilder1 == null)
            stringBuilder = new StringBuilder(); 
          stringBuilder.append(this.buffer, this.pos, b);
          this.pos += b;
          stringBuilder1 = stringBuilder;
          break;
        } 
        stringBuilder2 = stringBuilder1;
        break;
      } 
      if (!fillBuffer(1)) {
        b = bool;
        break;
      } 
    } 
    if (stringBuilder2 == null) {
      str = new String(this.buffer, this.pos, b);
    } else {
      str.append(this.buffer, this.pos, b);
      str = str.toString();
    } 
    this.pos += b;
    return str;
  }
  
  private int peekKeyword() throws IOException {
    String str1;
    String str2;
    char c = this.buffer[this.pos];
    if (c == 't' || c == 'T') {
      c = '\005';
      str1 = "true";
      str2 = "TRUE";
    } else if (c == 'f' || c == 'F') {
      c = '\006';
      str1 = "false";
      str2 = "FALSE";
    } else if (c == 'n' || c == 'N') {
      c = '\007';
      str1 = "null";
      str2 = "NULL";
    } else {
      return 0;
    } 
    int i = str1.length();
    for (byte b = 1; b < i; b++) {
      if (this.pos + b >= this.limit && !fillBuffer(b + 1))
        return 0; 
      char c1 = this.buffer[this.pos + b];
      if (c1 != str1.charAt(b) && c1 != str2.charAt(b))
        return 0; 
    } 
    if ((this.pos + i < this.limit || fillBuffer(i + 1)) && isLiteral(this.buffer[this.pos + i]))
      return 0; 
    this.pos += i;
    this.peeked = c;
    return c;
  }
  
  private int peekNumber() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: getfield buffer : [C
    //   4: astore_1
    //   5: aload_0
    //   6: getfield pos : I
    //   9: istore_2
    //   10: aload_0
    //   11: getfield limit : I
    //   14: istore_3
    //   15: iconst_1
    //   16: istore #4
    //   18: iconst_0
    //   19: istore #5
    //   21: iload #5
    //   23: istore #6
    //   25: iload #6
    //   27: istore #7
    //   29: lconst_0
    //   30: lstore #8
    //   32: iload_2
    //   33: istore #10
    //   35: iload_3
    //   36: istore #11
    //   38: iload_2
    //   39: iload #5
    //   41: iadd
    //   42: iload_3
    //   43: if_icmpne -> 81
    //   46: iload #5
    //   48: aload_1
    //   49: arraylength
    //   50: if_icmpne -> 55
    //   53: iconst_0
    //   54: ireturn
    //   55: aload_0
    //   56: iload #5
    //   58: iconst_1
    //   59: iadd
    //   60: invokespecial fillBuffer : (I)Z
    //   63: ifne -> 69
    //   66: goto -> 310
    //   69: aload_0
    //   70: getfield pos : I
    //   73: istore #10
    //   75: aload_0
    //   76: getfield limit : I
    //   79: istore #11
    //   81: aload_1
    //   82: iload #10
    //   84: iload #5
    //   86: iadd
    //   87: caload
    //   88: istore #12
    //   90: iconst_3
    //   91: istore_3
    //   92: iload #12
    //   94: bipush #43
    //   96: if_icmpeq -> 484
    //   99: iload #12
    //   101: bipush #69
    //   103: if_icmpeq -> 461
    //   106: iload #12
    //   108: bipush #101
    //   110: if_icmpeq -> 461
    //   113: iload #12
    //   115: bipush #45
    //   117: if_icmpeq -> 429
    //   120: iload #12
    //   122: bipush #46
    //   124: if_icmpeq -> 415
    //   127: iload #12
    //   129: bipush #48
    //   131: if_icmplt -> 301
    //   134: iload #12
    //   136: bipush #57
    //   138: if_icmple -> 144
    //   141: goto -> 301
    //   144: iload #6
    //   146: iconst_1
    //   147: if_icmpeq -> 274
    //   150: iload #6
    //   152: ifne -> 158
    //   155: goto -> 274
    //   158: iload #6
    //   160: iconst_2
    //   161: if_icmpne -> 232
    //   164: lload #8
    //   166: lconst_0
    //   167: lcmp
    //   168: ifne -> 173
    //   171: iconst_0
    //   172: ireturn
    //   173: ldc2_w 10
    //   176: lload #8
    //   178: lmul
    //   179: iload #12
    //   181: bipush #48
    //   183: isub
    //   184: i2l
    //   185: lsub
    //   186: lstore #13
    //   188: lload #8
    //   190: ldc2_w -922337203685477580
    //   193: lcmp
    //   194: istore_3
    //   195: iload_3
    //   196: ifgt -> 219
    //   199: iload_3
    //   200: ifne -> 214
    //   203: lload #13
    //   205: lload #8
    //   207: lcmp
    //   208: ifge -> 214
    //   211: goto -> 219
    //   214: iconst_0
    //   215: istore_3
    //   216: goto -> 221
    //   219: iconst_1
    //   220: istore_3
    //   221: iload_3
    //   222: iload #4
    //   224: iand
    //   225: istore_3
    //   226: iload #6
    //   228: istore_2
    //   229: goto -> 288
    //   232: iload #6
    //   234: iconst_3
    //   235: if_icmpne -> 244
    //   238: iconst_4
    //   239: istore #6
    //   241: goto -> 496
    //   244: iload #6
    //   246: iconst_5
    //   247: if_icmpeq -> 267
    //   250: iload #6
    //   252: istore_2
    //   253: iload #4
    //   255: istore_3
    //   256: lload #8
    //   258: lstore #13
    //   260: iload #6
    //   262: bipush #6
    //   264: if_icmpne -> 288
    //   267: bipush #7
    //   269: istore #6
    //   271: goto -> 496
    //   274: iload #12
    //   276: bipush #48
    //   278: isub
    //   279: ineg
    //   280: i2l
    //   281: lstore #13
    //   283: iconst_2
    //   284: istore_2
    //   285: iload #4
    //   287: istore_3
    //   288: iload_2
    //   289: istore #6
    //   291: iload_3
    //   292: istore #4
    //   294: lload #13
    //   296: lstore #8
    //   298: goto -> 496
    //   301: aload_0
    //   302: iload #12
    //   304: invokespecial isLiteral : (C)Z
    //   307: ifne -> 413
    //   310: iload #6
    //   312: iconst_2
    //   313: if_icmpne -> 374
    //   316: iload #4
    //   318: ifeq -> 374
    //   321: lload #8
    //   323: ldc2_w -9223372036854775808
    //   326: lcmp
    //   327: ifne -> 335
    //   330: iload #7
    //   332: ifeq -> 374
    //   335: iload #7
    //   337: ifeq -> 343
    //   340: goto -> 348
    //   343: lload #8
    //   345: lneg
    //   346: lstore #8
    //   348: aload_0
    //   349: lload #8
    //   351: putfield peekedLong : J
    //   354: aload_0
    //   355: aload_0
    //   356: getfield pos : I
    //   359: iload #5
    //   361: iadd
    //   362: putfield pos : I
    //   365: aload_0
    //   366: bipush #15
    //   368: putfield peeked : I
    //   371: bipush #15
    //   373: ireturn
    //   374: iload #6
    //   376: iconst_2
    //   377: if_icmpeq -> 398
    //   380: iload #6
    //   382: iconst_4
    //   383: if_icmpeq -> 398
    //   386: iload #6
    //   388: bipush #7
    //   390: if_icmpne -> 396
    //   393: goto -> 398
    //   396: iconst_0
    //   397: ireturn
    //   398: aload_0
    //   399: iload #5
    //   401: putfield peekedNumberLength : I
    //   404: aload_0
    //   405: bipush #16
    //   407: putfield peeked : I
    //   410: bipush #16
    //   412: ireturn
    //   413: iconst_0
    //   414: ireturn
    //   415: iload #6
    //   417: iconst_2
    //   418: if_icmpne -> 427
    //   421: iload_3
    //   422: istore #6
    //   424: goto -> 496
    //   427: iconst_0
    //   428: ireturn
    //   429: bipush #6
    //   431: istore_3
    //   432: iload #6
    //   434: ifne -> 447
    //   437: iconst_1
    //   438: istore #6
    //   440: iload #6
    //   442: istore #7
    //   444: goto -> 496
    //   447: iload #6
    //   449: iconst_5
    //   450: if_icmpne -> 459
    //   453: iload_3
    //   454: istore #6
    //   456: goto -> 496
    //   459: iconst_0
    //   460: ireturn
    //   461: iload #6
    //   463: iconst_2
    //   464: if_icmpeq -> 478
    //   467: iload #6
    //   469: iconst_4
    //   470: if_icmpne -> 476
    //   473: goto -> 478
    //   476: iconst_0
    //   477: ireturn
    //   478: iconst_5
    //   479: istore #6
    //   481: goto -> 496
    //   484: bipush #6
    //   486: istore_3
    //   487: iload #6
    //   489: iconst_5
    //   490: if_icmpne -> 508
    //   493: iload_3
    //   494: istore #6
    //   496: iinc #5, 1
    //   499: iload #10
    //   501: istore_2
    //   502: iload #11
    //   504: istore_3
    //   505: goto -> 32
    //   508: iconst_0
    //   509: ireturn
  }
  
  private void push(int paramInt) {
    int i = this.stackSize;
    int[] arrayOfInt = this.stack;
    if (i == arrayOfInt.length) {
      int[] arrayOfInt1 = new int[i * 2];
      int[] arrayOfInt2 = new int[i * 2];
      String[] arrayOfString = new String[i * 2];
      System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, i);
      System.arraycopy(this.pathIndices, 0, arrayOfInt2, 0, this.stackSize);
      System.arraycopy(this.pathNames, 0, arrayOfString, 0, this.stackSize);
      this.stack = arrayOfInt1;
      this.pathIndices = arrayOfInt2;
      this.pathNames = arrayOfString;
    } 
    arrayOfInt = this.stack;
    i = this.stackSize;
    this.stackSize = i + 1;
    arrayOfInt[i] = paramInt;
  }
  
  private char readEscapeCharacter() throws IOException {
    if (this.pos != this.limit || fillBuffer(1)) {
      char c;
      char[] arrayOfChar = this.buffer;
      int i = this.pos;
      this.pos = i + 1;
      int j = arrayOfChar[i];
      if (j != 10) {
        if (j != 34 && j != 39 && j != 47 && j != 92) {
          if (j != 98) {
            if (j != 102) {
              if (j != 110) {
                if (j != 114) {
                  if (j != 116) {
                    if (j == 117) {
                      if (this.pos + 4 <= this.limit || fillBuffer(4)) {
                        int k = 0;
                        int m = this.pos;
                        i = m;
                        j = k;
                        while (true) {
                          k = i;
                          if (k < m + 4) {
                            char c1 = this.buffer[k];
                            char c2 = (char)(j << 4);
                            if (c1 >= '0' && c1 <= '9') {
                              c1 -= '0';
                            } else {
                              if (c1 >= 'a' && c1 <= 'f') {
                                c1 -= 'a';
                              } else if (c1 >= 'A') {
                                if (c1 <= 'F') {
                                  c1 -= 'A';
                                } else {
                                  StringBuilder stringBuilder = new StringBuilder();
                                  stringBuilder.append("\\u");
                                  stringBuilder.append(new String(this.buffer, this.pos, 4));
                                  throw new NumberFormatException(stringBuilder.toString());
                                } 
                              } else {
                                continue;
                              } 
                              c1 += '\n';
                            } 
                            c2 = (char)(c2 + c1);
                            int n = k + 1;
                            c = c2;
                            continue;
                          } 
                          this.pos += 4;
                          return c;
                        } 
                      } 
                      throw syntaxError("Unterminated escape sequence");
                    } 
                    throw syntaxError("Invalid escape sequence");
                  } 
                  return '\t';
                } 
                return '\r';
              } 
              return '\n';
            } 
            return '\f';
          } 
          return '\b';
        } 
      } else {
        this.lineNumber++;
        this.lineStart = this.pos;
      } 
      return c;
    } 
    throw syntaxError("Unterminated escape sequence");
  }
  
  private void skipQuotedValue(char paramChar) throws IOException {
    char[] arrayOfChar = this.buffer;
    while (true) {
      int i = this.pos;
      int j = this.limit;
      while (i < j) {
        int k = i + 1;
        i = arrayOfChar[i];
        if (i == paramChar) {
          this.pos = k;
          return;
        } 
        if (i == 92) {
          this.pos = k;
          readEscapeCharacter();
          i = this.pos;
          j = this.limit;
          continue;
        } 
        if (i == 10) {
          this.lineNumber++;
          this.lineStart = k;
        } 
        i = k;
      } 
      this.pos = i;
      if (fillBuffer(1))
        continue; 
      throw syntaxError("Unterminated string");
    } 
  }
  
  private boolean skipTo(String paramString) throws IOException {
    label19: while (true) {
      int i = this.pos;
      int j = paramString.length();
      int k = this.limit;
      byte b = 0;
      if (i + j <= k || fillBuffer(paramString.length())) {
        char[] arrayOfChar = this.buffer;
        k = this.pos;
        if (arrayOfChar[k] == '\n') {
          this.lineNumber++;
          this.lineStart = k + 1;
          continue;
        } 
        while (b < paramString.length()) {
          if (this.buffer[this.pos + b] != paramString.charAt(b)) {
            this.pos++;
            continue label19;
          } 
          b++;
        } 
        return true;
      } 
      return false;
    } 
  }
  
  private void skipToEndOfLine() throws IOException {
    while (this.pos < this.limit || fillBuffer(1)) {
      char[] arrayOfChar = this.buffer;
      int i = this.pos;
      this.pos = i + 1;
      i = arrayOfChar[i];
      if (i == 10) {
        this.lineNumber++;
        this.lineStart = this.pos;
        break;
      } 
      if (i == 13)
        break; 
    } 
  }
  
  private void skipUnquotedValue() throws IOException {
    do {
      byte b = 0;
      while (true) {
        int i = this.pos;
        if (i + b < this.limit) {
          i = this.buffer[i + b];
          if (i != 9 && i != 10 && i != 12 && i != 13 && i != 32)
            if (i != 35) {
              if (i != 44)
                if (i != 47 && i != 61) {
                  if (i != 123 && i != 125 && i != 58)
                    if (i != 59) {
                      switch (i) {
                        default:
                          b++;
                          continue;
                        case 92:
                          checkLenient();
                          break;
                        case 91:
                        case 93:
                          break;
                      } 
                    } else {
                    
                    }  
                } else {
                
                }  
            } else {
            
            }  
          this.pos += b;
          return;
        } 
        this.pos = i + b;
        break;
      } 
    } while (fillBuffer(1));
  }
  
  private IOException syntaxError(String paramString) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(locationString());
    throw new MalformedJsonException(stringBuilder.toString());
  }
  
  public void beginArray() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 3) {
      push(1);
      this.pathIndices[this.stackSize - 1] = 0;
      this.peeked = 0;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected BEGIN_ARRAY but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void beginObject() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 1) {
      push(3);
      this.peeked = 0;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected BEGIN_OBJECT but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void close() throws IOException {
    this.peeked = 0;
    this.stack[0] = 8;
    this.stackSize = 1;
    this.in.close();
  }
  
  int doPeek() throws IOException {
    int[] arrayOfInt = this.stack;
    int i = this.stackSize;
    int j = arrayOfInt[i - 1];
    if (j == 1) {
      arrayOfInt[i - 1] = 2;
    } else if (j == 2) {
      i = nextNonWhitespace(true);
      if (i != 44) {
        if (i != 59) {
          if (i == 93) {
            this.peeked = 4;
            return 4;
          } 
          throw syntaxError("Unterminated array");
        } 
        checkLenient();
      } 
    } else {
      if (j == 3 || j == 5) {
        this.stack[this.stackSize - 1] = 4;
        if (j == 5) {
          i = nextNonWhitespace(true);
          if (i != 44) {
            if (i != 59) {
              if (i == 125) {
                this.peeked = 2;
                return 2;
              } 
              throw syntaxError("Unterminated object");
            } 
            checkLenient();
          } 
        } 
        i = nextNonWhitespace(true);
        if (i != 34) {
          if (i != 39) {
            if (i != 125) {
              checkLenient();
              this.pos--;
              if (isLiteral((char)i)) {
                this.peeked = 14;
                return 14;
              } 
              throw syntaxError("Expected name");
            } 
            if (j != 5) {
              this.peeked = 2;
              return 2;
            } 
            throw syntaxError("Expected name");
          } 
          checkLenient();
          this.peeked = 12;
          return 12;
        } 
        this.peeked = 13;
        return 13;
      } 
      if (j == 4) {
        arrayOfInt[i - 1] = 5;
        i = nextNonWhitespace(true);
        if (i != 58)
          if (i == 61) {
            checkLenient();
            if (this.pos < this.limit || fillBuffer(1)) {
              char[] arrayOfChar = this.buffer;
              i = this.pos;
              if (arrayOfChar[i] == '>')
                this.pos = i + 1; 
            } 
          } else {
            throw syntaxError("Expected ':'");
          }  
      } else if (j == 6) {
        if (this.lenient)
          consumeNonExecutePrefix(); 
        this.stack[this.stackSize - 1] = 7;
      } else if (j == 7) {
        if (nextNonWhitespace(false) == -1) {
          this.peeked = 17;
          return 17;
        } 
        checkLenient();
        this.pos--;
      } else if (j == 8) {
        throw new IllegalStateException("JsonReader is closed");
      } 
    } 
    i = nextNonWhitespace(true);
    if (i != 34) {
      if (i != 39) {
        if (i != 44 && i != 59)
          if (i != 91) {
            if (i != 93) {
              if (i != 123) {
                this.pos--;
                j = peekKeyword();
                if (j != 0)
                  return j; 
                j = peekNumber();
                if (j != 0)
                  return j; 
                if (isLiteral(this.buffer[this.pos])) {
                  checkLenient();
                  this.peeked = 10;
                  return 10;
                } 
                throw syntaxError("Expected value");
              } 
              this.peeked = 1;
              return 1;
            } 
            if (j == 1) {
              this.peeked = 4;
              return 4;
            } 
          } else {
            this.peeked = 3;
            return 3;
          }  
        if (j == 1 || j == 2) {
          checkLenient();
          this.pos--;
          this.peeked = 7;
          return 7;
        } 
        throw syntaxError("Unexpected value");
      } 
      checkLenient();
      this.peeked = 8;
      return 8;
    } 
    this.peeked = 9;
    return 9;
  }
  
  public void endArray() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 4) {
      this.stackSize--;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      this.peeked = 0;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected END_ARRAY but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public void endObject() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 2) {
      this.stackSize--;
      String[] arrayOfString = this.pathNames;
      j = this.stackSize;
      arrayOfString[j] = null;
      int[] arrayOfInt = this.pathIndices;
      arrayOfInt[--j] = arrayOfInt[j] + 1;
      this.peeked = 0;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected END_OBJECT but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public String getPath() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('$');
    int i = this.stackSize;
    for (byte b = 0; b < i; b++) {
      int j = this.stack[b];
      if (j != 1 && j != 2) {
        if (j == 3 || j == 4 || j == 5) {
          stringBuilder.append('.');
          String[] arrayOfString = this.pathNames;
          if (arrayOfString[b] != null)
            stringBuilder.append(arrayOfString[b]); 
        } 
      } else {
        stringBuilder.append('[');
        stringBuilder.append(this.pathIndices[b]);
        stringBuilder.append(']');
      } 
    } 
    return stringBuilder.toString();
  }
  
  public boolean hasNext() throws IOException {
    boolean bool;
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j != 2 && j != 4) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  public final boolean isLenient() {
    return this.lenient;
  }
  
  public boolean nextBoolean() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 5) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return true;
    } 
    if (j == 6) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected a boolean but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public double nextDouble() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 15) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return this.peekedLong;
    } 
    if (j == 16) {
      this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    } else if (j == 8 || j == 9) {
      int k;
      if (j == 8) {
        j = 39;
        k = j;
      } else {
        j = 34;
        k = j;
      } 
      this.peekedString = nextQuotedValue(k);
    } else if (j == 10) {
      this.peekedString = nextUnquotedValue();
    } else if (j != 11) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Expected a double but was ");
      stringBuilder1.append(peek());
      stringBuilder1.append(locationString());
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    this.peeked = 11;
    double d = Double.parseDouble(this.peekedString);
    if (this.lenient || (!Double.isNaN(d) && !Double.isInfinite(d))) {
      this.peekedString = null;
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return d;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("JSON forbids NaN and infinities: ");
    stringBuilder.append(d);
    stringBuilder.append(locationString());
    throw new MalformedJsonException(stringBuilder.toString());
  }
  
  public int nextInt() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 15) {
      long l = this.peekedLong;
      i = (int)l;
      if (l == i) {
        this.peeked = 0;
        int[] arrayOfInt = this.pathIndices;
        j = this.stackSize - 1;
        arrayOfInt[j] = arrayOfInt[j] + 1;
        return i;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Expected an int but was ");
      stringBuilder1.append(this.peekedLong);
      stringBuilder1.append(locationString());
      throw new NumberFormatException(stringBuilder1.toString());
    } 
    if (j == 16) {
      this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    } else if (j == 8 || j == 9 || j == 10) {
      if (j == 10) {
        this.peekedString = nextUnquotedValue();
      } else {
        int k;
        if (j == 8) {
          j = 39;
          k = j;
        } else {
          j = 34;
          k = j;
        } 
        this.peekedString = nextQuotedValue(k);
      } 
      try {
        j = Integer.parseInt(this.peekedString);
        this.peeked = 0;
        int[] arrayOfInt = this.pathIndices;
        i = this.stackSize - 1;
        arrayOfInt[i] = arrayOfInt[i] + 1;
        return j;
      } catch (NumberFormatException numberFormatException) {}
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Expected an int but was ");
      stringBuilder1.append(peek());
      stringBuilder1.append(locationString());
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    this.peeked = 11;
    double d = Double.parseDouble(this.peekedString);
    j = (int)d;
    if (j == d) {
      this.peekedString = null;
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      i = this.stackSize - 1;
      arrayOfInt[i] = arrayOfInt[i] + 1;
      return j;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected an int but was ");
    stringBuilder.append(this.peekedString);
    stringBuilder.append(locationString());
    throw new NumberFormatException(stringBuilder.toString());
  }
  
  public long nextLong() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 15) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return this.peekedLong;
    } 
    if (j == 16) {
      this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
      this.pos += this.peekedNumberLength;
    } else if (j == 8 || j == 9 || j == 10) {
      if (j == 10) {
        this.peekedString = nextUnquotedValue();
      } else {
        int k;
        if (j == 8) {
          j = 39;
          k = j;
        } else {
          j = 34;
          k = j;
        } 
        this.peekedString = nextQuotedValue(k);
      } 
      try {
        long l1 = Long.parseLong(this.peekedString);
        this.peeked = 0;
        int[] arrayOfInt = this.pathIndices;
        j = this.stackSize - 1;
        arrayOfInt[j] = arrayOfInt[j] + 1;
        return l1;
      } catch (NumberFormatException numberFormatException) {}
    } else {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Expected a long but was ");
      stringBuilder1.append(peek());
      stringBuilder1.append(locationString());
      throw new IllegalStateException(stringBuilder1.toString());
    } 
    this.peeked = 11;
    double d = Double.parseDouble(this.peekedString);
    long l = (long)d;
    if (l == d) {
      this.peekedString = null;
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return l;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected a long but was ");
    stringBuilder.append(this.peekedString);
    stringBuilder.append(locationString());
    throw new NumberFormatException(stringBuilder.toString());
  }
  
  public String nextName() throws IOException {
    StringBuilder stringBuilder;
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 14) {
      String str = nextUnquotedValue();
    } else if (j == 12) {
      String str = nextQuotedValue('\'');
    } else {
      if (j == 13) {
        String str = nextQuotedValue('"');
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Expected a name but was ");
      stringBuilder.append(peek());
      stringBuilder.append(locationString());
      throw new IllegalStateException(stringBuilder.toString());
    } 
    this.peeked = 0;
    this.pathNames[this.stackSize - 1] = (String)stringBuilder;
    return (String)stringBuilder;
  }
  
  public void nextNull() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 7) {
      this.peeked = 0;
      int[] arrayOfInt = this.pathIndices;
      j = this.stackSize - 1;
      arrayOfInt[j] = arrayOfInt[j] + 1;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected null but was ");
    stringBuilder.append(peek());
    stringBuilder.append(locationString());
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public String nextString() throws IOException {
    StringBuilder stringBuilder;
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    if (j == 10) {
      String str = nextUnquotedValue();
    } else if (j == 8) {
      String str = nextQuotedValue('\'');
    } else if (j == 9) {
      String str = nextQuotedValue('"');
    } else if (j == 11) {
      String str = this.peekedString;
      this.peekedString = null;
    } else if (j == 15) {
      String str = Long.toString(this.peekedLong);
    } else {
      if (j == 16) {
        String str = new String(this.buffer, this.pos, this.peekedNumberLength);
        this.pos += this.peekedNumberLength;
        this.peeked = 0;
        int[] arrayOfInt1 = this.pathIndices;
        j = this.stackSize - 1;
        arrayOfInt1[j] = arrayOfInt1[j] + 1;
        return str;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Expected a string but was ");
      stringBuilder.append(peek());
      stringBuilder.append(locationString());
      throw new IllegalStateException(stringBuilder.toString());
    } 
    this.peeked = 0;
    int[] arrayOfInt = this.pathIndices;
    j = this.stackSize - 1;
    arrayOfInt[j] = arrayOfInt[j] + 1;
    return (String)stringBuilder;
  }
  
  public JsonToken peek() throws IOException {
    int i = this.peeked;
    int j = i;
    if (i == 0)
      j = doPeek(); 
    switch (j) {
      default:
        throw new AssertionError();
      case 17:
        return JsonToken.END_DOCUMENT;
      case 15:
      case 16:
        return JsonToken.NUMBER;
      case 12:
      case 13:
      case 14:
        return JsonToken.NAME;
      case 8:
      case 9:
      case 10:
      case 11:
        return JsonToken.STRING;
      case 7:
        return JsonToken.NULL;
      case 5:
      case 6:
        return JsonToken.BOOLEAN;
      case 4:
        return JsonToken.END_ARRAY;
      case 3:
        return JsonToken.BEGIN_ARRAY;
      case 2:
        return JsonToken.END_OBJECT;
      case 1:
        break;
    } 
    return JsonToken.BEGIN_OBJECT;
  }
  
  public final void setLenient(boolean paramBoolean) {
    this.lenient = paramBoolean;
  }
  
  public void skipValue() throws IOException {
    for (int i = 0;; i = j) {
      int j = this.peeked;
      int k = j;
      if (j == 0)
        k = doPeek(); 
      if (k == 3) {
        push(1);
      } else if (k == 1) {
        push(3);
      } else {
        if (k == 4) {
          this.stackSize--;
        } else if (k == 2) {
          this.stackSize--;
        } else {
          if (k == 14 || k == 10) {
            skipUnquotedValue();
            j = i;
          } else if (k == 8 || k == 12) {
            skipQuotedValue('\'');
            j = i;
          } else if (k == 9 || k == 13) {
            skipQuotedValue('"');
            j = i;
          } else {
            j = i;
            if (k == 16) {
              this.pos += this.peekedNumberLength;
              j = i;
            } 
          } 
          this.peeked = 0;
          i = j;
        } 
        j = i - 1;
        this.peeked = 0;
        i = j;
      } 
      j = i + 1;
      this.peeked = 0;
    } 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getClass().getSimpleName());
    stringBuilder.append(locationString());
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\gson\stream\JsonReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */