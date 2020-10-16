package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.mutation.SetMutation;
import com.google.firebase.firestore.model.mutation.TransformMutation;
import com.google.firebase.firestore.model.mutation.TransformOperation;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserData {
  public static class ParseAccumulator {
    private final UserData.Source dataSource;
    
    private final Set<FieldPath> fieldMask;
    
    private final ArrayList<FieldTransform> fieldTransforms;
    
    public ParseAccumulator(UserData.Source param1Source) {
      this.dataSource = param1Source;
      this.fieldMask = new HashSet<>();
      this.fieldTransforms = new ArrayList<>();
    }
    
    void addToFieldMask(FieldPath param1FieldPath) {
      this.fieldMask.add(param1FieldPath);
    }
    
    void addToFieldTransforms(FieldPath param1FieldPath, TransformOperation param1TransformOperation) {
      this.fieldTransforms.add(new FieldTransform(param1FieldPath, param1TransformOperation));
    }
    
    public boolean contains(FieldPath param1FieldPath) {
      Iterator<FieldPath> iterator = this.fieldMask.iterator();
      while (iterator.hasNext()) {
        if (param1FieldPath.isPrefixOf((BasePath)iterator.next()))
          return true; 
      } 
      iterator = (Iterator)this.fieldTransforms.iterator();
      while (iterator.hasNext()) {
        if (param1FieldPath.isPrefixOf((BasePath)((FieldTransform)iterator.next()).getFieldPath()))
          return true; 
      } 
      return false;
    }
    
    public UserData.Source getDataSource() {
      return this.dataSource;
    }
    
    public List<FieldTransform> getFieldTransforms() {
      return this.fieldTransforms;
    }
    
    public UserData.ParseContext rootContext() {
      return new UserData.ParseContext(this, FieldPath.EMPTY_PATH, false);
    }
    
    public UserData.ParsedSetData toMergeData(ObjectValue param1ObjectValue) {
      return new UserData.ParsedSetData(param1ObjectValue, FieldMask.fromSet(this.fieldMask), Collections.unmodifiableList(this.fieldTransforms));
    }
    
    public UserData.ParsedSetData toMergeData(ObjectValue param1ObjectValue, FieldMask param1FieldMask) {
      ArrayList<FieldTransform> arrayList = new ArrayList();
      for (FieldTransform fieldTransform : this.fieldTransforms) {
        if (param1FieldMask.covers(fieldTransform.getFieldPath()))
          arrayList.add(fieldTransform); 
      } 
      return new UserData.ParsedSetData(param1ObjectValue, param1FieldMask, Collections.unmodifiableList(arrayList));
    }
    
    public UserData.ParsedSetData toSetData(ObjectValue param1ObjectValue) {
      return new UserData.ParsedSetData(param1ObjectValue, null, Collections.unmodifiableList(this.fieldTransforms));
    }
    
    public UserData.ParsedUpdateData toUpdateData(ObjectValue param1ObjectValue) {
      return new UserData.ParsedUpdateData(param1ObjectValue, FieldMask.fromSet(this.fieldMask), Collections.unmodifiableList(this.fieldTransforms));
    }
  }
  
  public static class ParseContext {
    private static final String RESERVED_FIELD_DESIGNATOR = "__";
    
    private final UserData.ParseAccumulator accumulator;
    
    private final boolean arrayElement;
    
    private final FieldPath path;
    
    private ParseContext(UserData.ParseAccumulator param1ParseAccumulator, FieldPath param1FieldPath, boolean param1Boolean) {
      this.accumulator = param1ParseAccumulator;
      this.path = param1FieldPath;
      this.arrayElement = param1Boolean;
    }
    
    private void validatePath() {
      if (this.path == null)
        return; 
      for (byte b = 0; b < this.path.length(); b++)
        validatePathSegment(this.path.getSegment(b)); 
    }
    
    private void validatePathSegment(String param1String) {
      if (!param1String.isEmpty()) {
        if (!isWrite() || !param1String.startsWith("__") || !param1String.endsWith("__"))
          return; 
        throw createError("Document fields cannot begin and end with \"__\"");
      } 
      throw createError("Document fields must not be empty");
    }
    
    public void addToFieldMask(FieldPath param1FieldPath) {
      this.accumulator.addToFieldMask(param1FieldPath);
    }
    
    public void addToFieldTransforms(FieldPath param1FieldPath, TransformOperation param1TransformOperation) {
      this.accumulator.addToFieldTransforms(param1FieldPath, param1TransformOperation);
    }
    
    public ParseContext childContext(int param1Int) {
      return new ParseContext(this.accumulator, null, true);
    }
    
    public ParseContext childContext(FieldPath param1FieldPath) {
      FieldPath fieldPath = this.path;
      if (fieldPath == null) {
        param1FieldPath = null;
      } else {
        param1FieldPath = (FieldPath)fieldPath.append((BasePath)param1FieldPath);
      } 
      ParseContext parseContext = new ParseContext(this.accumulator, param1FieldPath, false);
      parseContext.validatePath();
      return parseContext;
    }
    
    public ParseContext childContext(String param1String) {
      FieldPath fieldPath = this.path;
      if (fieldPath == null) {
        fieldPath = null;
      } else {
        fieldPath = (FieldPath)fieldPath.append(param1String);
      } 
      ParseContext parseContext = new ParseContext(this.accumulator, fieldPath, false);
      parseContext.validatePathSegment(param1String);
      return parseContext;
    }
    
    public RuntimeException createError(String param1String) {
      FieldPath fieldPath = this.path;
      if (fieldPath == null || fieldPath.isEmpty()) {
        String str1 = "";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid data. ");
        stringBuilder.append(param1String);
        stringBuilder.append(str1);
        return new IllegalArgumentException(stringBuilder.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" (found in field ");
      stringBuilder1.append(this.path.toString());
      stringBuilder1.append(")");
      String str = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("Invalid data. ");
      stringBuilder2.append(param1String);
      stringBuilder2.append(str);
      return new IllegalArgumentException(stringBuilder2.toString());
    }
    
    public UserData.Source getDataSource() {
      return this.accumulator.dataSource;
    }
    
    public FieldPath getPath() {
      return this.path;
    }
    
    public boolean isArrayElement() {
      return this.arrayElement;
    }
    
    public boolean isWrite() {
      int i = UserData.null.$SwitchMap$com$google$firebase$firestore$core$UserData$Source[this.accumulator.dataSource.ordinal()];
      if (i != 1 && i != 2 && i != 3) {
        if (i == 4 || i == 5)
          return false; 
        throw Assert.fail("Unexpected case for UserDataSource: %s", new Object[] { UserData.ParseAccumulator.access$100(this.accumulator).name() });
      } 
      return true;
    }
  }
  
  public static class ParsedSetData {
    private final ObjectValue data;
    
    private final FieldMask fieldMask;
    
    private final List<FieldTransform> fieldTransforms;
    
    ParsedSetData(ObjectValue param1ObjectValue, FieldMask param1FieldMask, List<FieldTransform> param1List) {
      this.data = param1ObjectValue;
      this.fieldMask = param1FieldMask;
      this.fieldTransforms = param1List;
    }
    
    public List<Mutation> toMutationList(DocumentKey param1DocumentKey, Precondition param1Precondition) {
      ArrayList<PatchMutation> arrayList = new ArrayList();
      FieldMask fieldMask = this.fieldMask;
      if (fieldMask != null) {
        arrayList.add(new PatchMutation(param1DocumentKey, this.data, fieldMask, param1Precondition));
      } else {
        arrayList.add(new SetMutation(param1DocumentKey, this.data, param1Precondition));
      } 
      if (!this.fieldTransforms.isEmpty())
        arrayList.add(new TransformMutation(param1DocumentKey, this.fieldTransforms)); 
      return (List)arrayList;
    }
  }
  
  public static class ParsedUpdateData {
    private final ObjectValue data;
    
    private final FieldMask fieldMask;
    
    private final List<FieldTransform> fieldTransforms;
    
    ParsedUpdateData(ObjectValue param1ObjectValue, FieldMask param1FieldMask, List<FieldTransform> param1List) {
      this.data = param1ObjectValue;
      this.fieldMask = param1FieldMask;
      this.fieldTransforms = param1List;
    }
    
    public List<FieldTransform> getFieldTransforms() {
      return this.fieldTransforms;
    }
    
    public List<Mutation> toMutationList(DocumentKey param1DocumentKey, Precondition param1Precondition) {
      ArrayList<PatchMutation> arrayList = new ArrayList();
      arrayList.add(new PatchMutation(param1DocumentKey, this.data, this.fieldMask, param1Precondition));
      if (!this.fieldTransforms.isEmpty())
        arrayList.add(new TransformMutation(param1DocumentKey, this.fieldTransforms)); 
      return (List)arrayList;
    }
  }
  
  public enum Source {
    Argument, ArrayArgument, MergeSet, Set, Update;
    
    static {
      Argument = new Source("Argument", 3);
      ArrayArgument = new Source("ArrayArgument", 4);
      $VALUES = new Source[] { Set, MergeSet, Update, Argument, ArrayArgument };
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\UserData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */