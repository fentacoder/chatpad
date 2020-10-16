package com.google.protobuf;

public enum Syntax implements Internal.EnumLite {
  SYNTAX_PROTO2(0),
  SYNTAX_PROTO3(1),
  UNRECOGNIZED(-1);
  
  public static final int SYNTAX_PROTO2_VALUE = 0;
  
  public static final int SYNTAX_PROTO3_VALUE = 1;
  
  private static final Internal.EnumLiteMap<Syntax> internalValueMap;
  
  private final int value;
  
  static {
    $VALUES = new Syntax[] { SYNTAX_PROTO2, SYNTAX_PROTO3, UNRECOGNIZED };
    internalValueMap = new Internal.EnumLiteMap<Syntax>() {
        public Syntax findValueByNumber(int param1Int) {
          return Syntax.forNumber(param1Int);
        }
      };
  }
  
  Syntax(int paramInt1) {
    this.value = paramInt1;
  }
  
  public static Syntax forNumber(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? null : SYNTAX_PROTO3) : SYNTAX_PROTO2;
  }
  
  public static Internal.EnumLiteMap<Syntax> internalGetValueMap() {
    return internalValueMap;
  }
  
  public final int getNumber() {
    return this.value;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\protobuf\Syntax.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */