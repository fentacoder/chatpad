package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.DoubleValue;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.NullValue;
import com.google.firebase.firestore.model.value.ReferenceValue;
import com.google.firebase.firestore.util.Assert;
import java.util.Arrays;

public class FieldFilter extends Filter {
  private final FieldPath field;
  
  private final Filter.Operator operator;
  
  private final FieldValue value;
  
  protected FieldFilter(FieldPath paramFieldPath, Filter.Operator paramOperator, FieldValue paramFieldValue) {
    this.field = paramFieldPath;
    this.operator = paramOperator;
    this.value = paramFieldValue;
  }
  
  public static FieldFilter create(FieldPath paramFieldPath, Filter.Operator paramOperator, FieldValue paramFieldValue) {
    StringBuilder stringBuilder;
    if (paramFieldPath.isKeyField()) {
      boolean bool;
      if (paramOperator == Filter.Operator.IN) {
        Assert.hardAssert(paramFieldValue instanceof ArrayValue, "Comparing on key with IN, but the value was not an ArrayValue", new Object[0]);
        return new KeyFieldInFilter(paramFieldPath, (ArrayValue)paramFieldValue);
      } 
      Assert.hardAssert(paramFieldValue instanceof ReferenceValue, "Comparing on key, but filter value not a ReferenceValue", new Object[0]);
      if (paramOperator != Filter.Operator.ARRAY_CONTAINS && paramOperator != Filter.Operator.ARRAY_CONTAINS_ANY) {
        bool = true;
      } else {
        bool = false;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramOperator.toString());
      stringBuilder1.append("queries don't make sense on document keys");
      Assert.hardAssert(bool, stringBuilder1.toString(), new Object[0]);
      return new KeyFieldFilter(paramFieldPath, paramOperator, (ReferenceValue)paramFieldValue);
    } 
    if (paramFieldValue.equals(NullValue.nullValue())) {
      if (paramOperator == Filter.Operator.EQUAL)
        return new FieldFilter(paramFieldPath, paramOperator, paramFieldValue); 
      throw new IllegalArgumentException("Invalid Query. Null supports only equality comparisons (via whereEqualTo()).");
    } 
    if (paramFieldValue.equals(DoubleValue.NaN)) {
      if (paramOperator == Filter.Operator.EQUAL)
        return new FieldFilter(paramFieldPath, paramOperator, paramFieldValue); 
      throw new IllegalArgumentException("Invalid Query. NaN supports only equality comparisons (via whereEqualTo()).");
    } 
    if (paramOperator == Filter.Operator.ARRAY_CONTAINS)
      return new ArrayContainsFilter(paramFieldPath, paramFieldValue); 
    if (paramOperator == Filter.Operator.IN) {
      boolean bool = paramFieldValue instanceof ArrayValue;
      stringBuilder = new StringBuilder();
      stringBuilder.append("IN filter has invalid value: ");
      stringBuilder.append(paramFieldValue.toString());
      Assert.hardAssert(bool, stringBuilder.toString(), new Object[0]);
      return new InFilter(paramFieldPath, (ArrayValue)paramFieldValue);
    } 
    if (stringBuilder == Filter.Operator.ARRAY_CONTAINS_ANY) {
      boolean bool = paramFieldValue instanceof ArrayValue;
      stringBuilder = new StringBuilder();
      stringBuilder.append("ARRAY_CONTAINS_ANY filter has invalid value: ");
      stringBuilder.append(paramFieldValue.toString());
      Assert.hardAssert(bool, stringBuilder.toString(), new Object[0]);
      return new ArrayContainsAnyFilter(paramFieldPath, paramFieldValue);
    } 
    return new FieldFilter(paramFieldPath, (Filter.Operator)stringBuilder, paramFieldValue);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null)
      if (!(paramObject instanceof FieldFilter)) {
        bool2 = bool1;
      } else {
        paramObject = paramObject;
        bool2 = bool1;
        if (this.operator == ((FieldFilter)paramObject).operator) {
          bool2 = bool1;
          if (this.field.equals(((FieldFilter)paramObject).field)) {
            bool2 = bool1;
            if (this.value.equals(((FieldFilter)paramObject).value))
              bool2 = true; 
          } 
        } 
      }  
    return bool2;
  }
  
  public String getCanonicalId() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getField().canonicalString());
    stringBuilder.append(getOperator().toString());
    stringBuilder.append(getValue().toString());
    return stringBuilder.toString();
  }
  
  public FieldPath getField() {
    return this.field;
  }
  
  public Filter.Operator getOperator() {
    return this.operator;
  }
  
  public FieldValue getValue() {
    return this.value;
  }
  
  public int hashCode() {
    return ((1147 + this.operator.hashCode()) * 31 + this.field.hashCode()) * 31 + this.value.hashCode();
  }
  
  public boolean isInequality() {
    return Arrays.<Filter.Operator>asList(new Filter.Operator[] { Filter.Operator.LESS_THAN, Filter.Operator.LESS_THAN_OR_EQUAL, Filter.Operator.GREATER_THAN, Filter.Operator.GREATER_THAN_OR_EQUAL }).contains(this.operator);
  }
  
  public boolean matches(Document paramDocument) {
    boolean bool;
    FieldValue fieldValue = paramDocument.getField(this.field);
    if (fieldValue != null && this.value.typeOrder() == fieldValue.typeOrder() && matchesComparison(fieldValue.compareTo(this.value))) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  protected boolean matchesComparison(int paramInt) {
    int i = null.$SwitchMap$com$google$firebase$firestore$core$Filter$Operator[this.operator.ordinal()];
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4) {
            if (i == 5) {
              if (paramInt >= 0)
                bool5 = true; 
              return bool5;
            } 
            throw Assert.fail("Unknown FieldFilter operator: %s", new Object[] { this.operator });
          } 
          bool5 = bool1;
          if (paramInt > 0)
            bool5 = true; 
          return bool5;
        } 
        bool5 = bool2;
        if (paramInt == 0)
          bool5 = true; 
        return bool5;
      } 
      bool5 = bool3;
      if (paramInt <= 0)
        bool5 = true; 
      return bool5;
    } 
    bool5 = bool4;
    if (paramInt < 0)
      bool5 = true; 
    return bool5;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.field.canonicalString());
    stringBuilder.append(" ");
    stringBuilder.append(this.operator);
    stringBuilder.append(" ");
    stringBuilder.append(this.value);
    return stringBuilder.toString();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\FieldFilter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */