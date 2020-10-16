package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import java.util.List;

final class TrieParser {
  private static final Joiner PREFIX_JOINER = Joiner.on("");
  
  private static int doParseTrieToBuilder(List<CharSequence> paramList, CharSequence paramCharSequence, int paramInt, ImmutableMap.Builder<String, PublicSuffixType> paramBuilder) {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface length : ()I
    //   6: istore #4
    //   8: iload_2
    //   9: istore #5
    //   11: iconst_0
    //   12: istore #6
    //   14: iload #6
    //   16: istore #7
    //   18: iload #5
    //   20: iload #4
    //   22: if_icmpge -> 99
    //   25: aload_1
    //   26: iload #5
    //   28: invokeinterface charAt : (I)C
    //   33: istore #6
    //   35: iload #6
    //   37: istore #7
    //   39: iload #6
    //   41: bipush #38
    //   43: if_icmpeq -> 99
    //   46: iload #6
    //   48: istore #7
    //   50: iload #6
    //   52: bipush #63
    //   54: if_icmpeq -> 99
    //   57: iload #6
    //   59: istore #7
    //   61: iload #6
    //   63: bipush #33
    //   65: if_icmpeq -> 99
    //   68: iload #6
    //   70: istore #7
    //   72: iload #6
    //   74: bipush #58
    //   76: if_icmpeq -> 99
    //   79: iload #6
    //   81: bipush #44
    //   83: if_icmpne -> 93
    //   86: iload #6
    //   88: istore #7
    //   90: goto -> 99
    //   93: iinc #5, 1
    //   96: goto -> 14
    //   99: aload_0
    //   100: iconst_0
    //   101: aload_1
    //   102: iload_2
    //   103: iload #5
    //   105: invokeinterface subSequence : (II)Ljava/lang/CharSequence;
    //   110: invokestatic reverse : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   113: invokeinterface add : (ILjava/lang/Object;)V
    //   118: iload #7
    //   120: bipush #33
    //   122: if_icmpeq -> 146
    //   125: iload #7
    //   127: bipush #63
    //   129: if_icmpeq -> 146
    //   132: iload #7
    //   134: bipush #58
    //   136: if_icmpeq -> 146
    //   139: iload #7
    //   141: bipush #44
    //   143: if_icmpne -> 175
    //   146: getstatic com/google/thirdparty/publicsuffix/TrieParser.PREFIX_JOINER : Lcom/google/common/base/Joiner;
    //   149: aload_0
    //   150: invokevirtual join : (Ljava/lang/Iterable;)Ljava/lang/String;
    //   153: astore #8
    //   155: aload #8
    //   157: invokevirtual length : ()I
    //   160: ifle -> 175
    //   163: aload_3
    //   164: aload #8
    //   166: iload #7
    //   168: invokestatic fromCode : (C)Lcom/google/thirdparty/publicsuffix/PublicSuffixType;
    //   171: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;
    //   174: pop
    //   175: iinc #5, 1
    //   178: iload #5
    //   180: istore #6
    //   182: iload #7
    //   184: bipush #63
    //   186: if_icmpeq -> 257
    //   189: iload #5
    //   191: istore #6
    //   193: iload #7
    //   195: bipush #44
    //   197: if_icmpeq -> 257
    //   200: iload #5
    //   202: istore #6
    //   204: iload #5
    //   206: iload #4
    //   208: if_icmpge -> 257
    //   211: iload #5
    //   213: aload_0
    //   214: aload_1
    //   215: iload #5
    //   217: aload_3
    //   218: invokestatic doParseTrieToBuilder : (Ljava/util/List;Ljava/lang/CharSequence;ILcom/google/common/collect/ImmutableMap$Builder;)I
    //   221: iadd
    //   222: istore #6
    //   224: aload_1
    //   225: iload #6
    //   227: invokeinterface charAt : (I)C
    //   232: bipush #63
    //   234: if_icmpeq -> 254
    //   237: iload #6
    //   239: istore #5
    //   241: aload_1
    //   242: iload #6
    //   244: invokeinterface charAt : (I)C
    //   249: bipush #44
    //   251: if_icmpne -> 200
    //   254: iinc #6, 1
    //   257: aload_0
    //   258: iconst_0
    //   259: invokeinterface remove : (I)Ljava/lang/Object;
    //   264: pop
    //   265: iload #6
    //   267: iload_2
    //   268: isub
    //   269: ireturn
  }
  
  static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence paramCharSequence) {
    ImmutableMap.Builder<String, PublicSuffixType> builder = ImmutableMap.builder();
    int i = paramCharSequence.length();
    for (int j = 0; j < i; j += doParseTrieToBuilder(Lists.newLinkedList(), paramCharSequence, j, builder));
    return builder.build();
  }
  
  private static CharSequence reverse(CharSequence paramCharSequence) {
    return (new StringBuilder(paramCharSequence)).reverse();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\thirdparty\publicsuffix\TrieParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */