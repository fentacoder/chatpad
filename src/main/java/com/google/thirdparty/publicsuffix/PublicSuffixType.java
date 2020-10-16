package com.google.thirdparty.publicsuffix;

public enum PublicSuffixType {
  PRIVATE(':', ','),
  REGISTRY('!', '?');
  
  private final char innerNodeCode;
  
  private final char leafNodeCode;
  
  static {
    $VALUES = new PublicSuffixType[] { PRIVATE, REGISTRY };
  }
  
  PublicSuffixType(char paramChar1, char paramChar2) {
    this.innerNodeCode = (char)paramChar1;
    this.leafNodeCode = (char)paramChar2;
  }
  
  static PublicSuffixType fromCode(char paramChar) {
    for (PublicSuffixType publicSuffixType : values()) {
      if (publicSuffixType.getInnerNodeCode() == paramChar || publicSuffixType.getLeafNodeCode() == paramChar)
        return publicSuffixType; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No enum corresponding to given code: ");
    stringBuilder.append(paramChar);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static PublicSuffixType fromIsPrivate(boolean paramBoolean) {
    PublicSuffixType publicSuffixType;
    if (paramBoolean) {
      publicSuffixType = PRIVATE;
    } else {
      publicSuffixType = REGISTRY;
    } 
    return publicSuffixType;
  }
  
  char getInnerNodeCode() {
    return this.innerNodeCode;
  }
  
  char getLeafNodeCode() {
    return this.leafNodeCode;
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\thirdparty\publicsuffix\PublicSuffixType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */