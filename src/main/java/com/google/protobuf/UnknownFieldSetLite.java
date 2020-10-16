package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;

public final class UnknownFieldSetLite {
  private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
  
  private static final int MIN_CAPACITY = 8;
  
  private int count;
  
  private boolean isMutable;
  
  private int memoizedSerializedSize = -1;
  
  private Object[] objects;
  
  private int[] tags;
  
  private UnknownFieldSetLite() {
    this(0, new int[8], new Object[8], true);
  }
  
  private UnknownFieldSetLite(int paramInt, int[] paramArrayOfint, Object[] paramArrayOfObject, boolean paramBoolean) {
    this.count = paramInt;
    this.tags = paramArrayOfint;
    this.objects = paramArrayOfObject;
    this.isMutable = paramBoolean;
  }
  
  private void ensureCapacity() {
    int i = this.count;
    if (i == this.tags.length) {
      if (i < 4) {
        i = 8;
      } else {
        i >>= 1;
      } 
      i = this.count + i;
      this.tags = Arrays.copyOf(this.tags, i);
      this.objects = Arrays.copyOf(this.objects, i);
    } 
  }
  
  public static UnknownFieldSetLite getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }
  
  private UnknownFieldSetLite mergeFrom(CodedInputStream paramCodedInputStream) throws IOException {
    int i;
    do {
      i = paramCodedInputStream.readTag();
    } while (i != 0 && mergeFieldFrom(i, paramCodedInputStream));
    return this;
  }
  
  static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite paramUnknownFieldSetLite1, UnknownFieldSetLite paramUnknownFieldSetLite2) {
    int i = paramUnknownFieldSetLite1.count + paramUnknownFieldSetLite2.count;
    int[] arrayOfInt = Arrays.copyOf(paramUnknownFieldSetLite1.tags, i);
    System.arraycopy(paramUnknownFieldSetLite2.tags, 0, arrayOfInt, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    Object[] arrayOfObject = Arrays.copyOf(paramUnknownFieldSetLite1.objects, i);
    System.arraycopy(paramUnknownFieldSetLite2.objects, 0, arrayOfObject, paramUnknownFieldSetLite1.count, paramUnknownFieldSetLite2.count);
    return new UnknownFieldSetLite(i, arrayOfInt, arrayOfObject, true);
  }
  
  static UnknownFieldSetLite newInstance() {
    return new UnknownFieldSetLite();
  }
  
  private void storeField(int paramInt, Object paramObject) {
    ensureCapacity();
    int[] arrayOfInt = this.tags;
    int i = this.count;
    arrayOfInt[i] = paramInt;
    this.objects[i] = paramObject;
    this.count = i + 1;
  }
  
  void checkMutable() {
    if (this.isMutable)
      return; 
    throw new UnsupportedOperationException();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof UnknownFieldSetLite))
      return false; 
    paramObject = paramObject;
    return !(this.count != ((UnknownFieldSetLite)paramObject).count || !Arrays.equals(this.tags, ((UnknownFieldSetLite)paramObject).tags) || !Arrays.deepEquals(this.objects, ((UnknownFieldSetLite)paramObject).objects));
  }
  
  public int getSerializedSize() {
    int i = this.memoizedSerializedSize;
    if (i != -1)
      return i; 
    byte b = 0;
    int j = 0;
    while (b < this.count) {
      int k = this.tags[b];
      i = WireFormat.getTagFieldNumber(k);
      k = WireFormat.getTagWireType(k);
      if (k != 0) {
        if (k != 1) {
          if (k != 2) {
            if (k != 3) {
              if (k == 5) {
                i = CodedOutputStream.computeFixed32Size(i, ((Integer)this.objects[b]).intValue());
              } else {
                throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
              } 
            } else {
              i = CodedOutputStream.computeTagSize(i) * 2 + ((UnknownFieldSetLite)this.objects[b]).getSerializedSize();
            } 
          } else {
            i = CodedOutputStream.computeBytesSize(i, (ByteString)this.objects[b]);
          } 
        } else {
          i = CodedOutputStream.computeFixed64Size(i, ((Long)this.objects[b]).longValue());
        } 
      } else {
        i = CodedOutputStream.computeUInt64Size(i, ((Long)this.objects[b]).longValue());
      } 
      j += i;
      b++;
    } 
    this.memoizedSerializedSize = j;
    return j;
  }
  
  public int hashCode() {
    return ((527 + this.count) * 31 + Arrays.hashCode(this.tags)) * 31 + Arrays.deepHashCode(this.objects);
  }
  
  public void makeImmutable() {
    this.isMutable = false;
  }
  
  boolean mergeFieldFrom(int paramInt, CodedInputStream paramCodedInputStream) throws IOException {
    checkMutable();
    int i = WireFormat.getTagFieldNumber(paramInt);
    int j = WireFormat.getTagWireType(paramInt);
    if (j != 0) {
      if (j != 1) {
        if (j != 2) {
          if (j != 3) {
            if (j != 4) {
              if (j == 5) {
                storeField(paramInt, Integer.valueOf(paramCodedInputStream.readFixed32()));
                return true;
              } 
              throw InvalidProtocolBufferException.invalidWireType();
            } 
            return false;
          } 
          UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
          unknownFieldSetLite.mergeFrom(paramCodedInputStream);
          paramCodedInputStream.checkLastTagWas(WireFormat.makeTag(i, 4));
          storeField(paramInt, unknownFieldSetLite);
          return true;
        } 
        storeField(paramInt, paramCodedInputStream.readBytes());
        return true;
      } 
      storeField(paramInt, Long.valueOf(paramCodedInputStream.readFixed64()));
      return true;
    } 
    storeField(paramInt, Long.valueOf(paramCodedInputStream.readInt64()));
    return true;
  }
  
  UnknownFieldSetLite mergeLengthDelimitedField(int paramInt, ByteString paramByteString) {
    checkMutable();
    if (paramInt != 0) {
      storeField(WireFormat.makeTag(paramInt, 2), paramByteString);
      return this;
    } 
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  UnknownFieldSetLite mergeVarintField(int paramInt1, int paramInt2) {
    checkMutable();
    if (paramInt1 != 0) {
      storeField(WireFormat.makeTag(paramInt1, 0), Long.valueOf(paramInt2));
      return this;
    } 
    throw new IllegalArgumentException("Zero is not a valid field number.");
  }
  
  final void printWithIndent(StringBuilder paramStringBuilder, int paramInt) {
    for (byte b = 0; b < this.count; b++)
      MessageLiteToString.printField(paramStringBuilder, paramInt, String.valueOf(WireFormat.getTagFieldNumber(this.tags[b])), this.objects[b]); 
  }
  
  public void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException {
    for (byte b = 0; b < this.count; b++) {
      int i = this.tags[b];
      int j = WireFormat.getTagFieldNumber(i);
      i = WireFormat.getTagWireType(i);
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3) {
              if (i == 5) {
                paramCodedOutputStream.writeFixed32(j, ((Integer)this.objects[b]).intValue());
              } else {
                throw InvalidProtocolBufferException.invalidWireType();
              } 
            } else {
              paramCodedOutputStream.writeTag(j, 3);
              ((UnknownFieldSetLite)this.objects[b]).writeTo(paramCodedOutputStream);
              paramCodedOutputStream.writeTag(j, 4);
            } 
          } else {
            paramCodedOutputStream.writeBytes(j, (ByteString)this.objects[b]);
          } 
        } else {
          paramCodedOutputStream.writeFixed64(j, ((Long)this.objects[b]).longValue());
        } 
      } else {
        paramCodedOutputStream.writeUInt64(j, ((Long)this.objects[b]).longValue());
      } 
    } 
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\UnknownFieldSetLite.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */