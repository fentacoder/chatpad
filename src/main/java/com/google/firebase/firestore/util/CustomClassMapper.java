package com.google.firebase.firestore.util;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.Blob;
import com.google.firebase.firestore.DocumentId;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.IgnoreExtraProperties;
import com.google.firebase.firestore.PropertyName;
import com.google.firebase.firestore.ServerTimestamp;
import com.google.firebase.firestore.ThrowOnExtraProperties;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class CustomClassMapper {
  private static final int MAX_DEPTH = 500;
  
  private static final ConcurrentMap<Class<?>, BeanMapper<?>> mappers = new ConcurrentHashMap<>();
  
  private static <T> T convertBean(Object paramObject, Class<T> paramClass, DeserializeContext paramDeserializeContext) {
    BeanMapper<T> beanMapper = loadOrCreateBeanMapperForClass(paramClass);
    if (paramObject instanceof Map)
      return beanMapper.deserialize(expectMap(paramObject, paramDeserializeContext), paramDeserializeContext); 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Can't convert object of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to type ");
    stringBuilder.append(paramClass.getName());
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static Blob convertBlob(Object paramObject, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof Blob)
      return (Blob)paramObject; 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to Blob");
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static Boolean convertBoolean(Object paramObject, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof Boolean)
      return (Boolean)paramObject; 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to boolean");
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static Date convertDate(Object paramObject, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof Date)
      return (Date)paramObject; 
    if (paramObject instanceof Timestamp)
      return ((Timestamp)paramObject).toDate(); 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to Date");
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static DocumentReference convertDocumentReference(Object paramObject, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof DocumentReference)
      return (DocumentReference)paramObject; 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to DocumentReference");
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static Double convertDouble(Object paramObject, DeserializeContext paramDeserializeContext) {
    ErrorPath errorPath1;
    if (paramObject instanceof Integer)
      return Double.valueOf(((Integer)paramObject).doubleValue()); 
    if (paramObject instanceof Long) {
      Long long_ = (Long)paramObject;
      Double double_ = Double.valueOf(long_.doubleValue());
      if (double_.longValue() == long_.longValue())
        return double_; 
      errorPath1 = paramDeserializeContext.errorPath;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Loss of precision while converting number to double: ");
      stringBuilder1.append(paramObject);
      stringBuilder1.append(". Did you mean to use a 64-bit long instead?");
      throw deserializeError(errorPath1, stringBuilder1.toString());
    } 
    if (paramObject instanceof Double)
      return (Double)paramObject; 
    ErrorPath errorPath2 = ((DeserializeContext)errorPath1).errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert a value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to double");
    throw deserializeError(errorPath2, stringBuilder.toString());
  }
  
  private static GeoPoint convertGeoPoint(Object paramObject, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof GeoPoint)
      return (GeoPoint)paramObject; 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to GeoPoint");
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static Integer convertInteger(Object paramObject, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof Integer)
      return (Integer)paramObject; 
    if (paramObject instanceof Long || paramObject instanceof Double) {
      paramObject = paramObject;
      double d = paramObject.doubleValue();
      if (d >= -2.147483648E9D && d <= 2.147483647E9D)
        return Integer.valueOf(paramObject.intValue()); 
      errorPath = paramDeserializeContext.errorPath;
      paramObject = new StringBuilder();
      paramObject.append("Numeric value out of 32-bit integer range: ");
      paramObject.append(d);
      paramObject.append(". Did you mean to use a long or double instead of an int?");
      throw deserializeError(errorPath, paramObject.toString());
    } 
    ErrorPath errorPath = ((DeserializeContext)errorPath).errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert a value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to int");
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static Long convertLong(Object paramObject, DeserializeContext paramDeserializeContext) {
    ErrorPath errorPath1;
    if (paramObject instanceof Integer)
      return Long.valueOf(((Integer)paramObject).longValue()); 
    if (paramObject instanceof Long)
      return (Long)paramObject; 
    if (paramObject instanceof Double) {
      paramObject = paramObject;
      if (paramObject.doubleValue() >= -9.223372036854776E18D && paramObject.doubleValue() <= 9.223372036854776E18D)
        return Long.valueOf(paramObject.longValue()); 
      errorPath1 = paramDeserializeContext.errorPath;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Numeric value out of 64-bit long range: ");
      stringBuilder1.append(paramObject);
      stringBuilder1.append(". Did you mean to use a double instead of a long?");
      throw deserializeError(errorPath1, stringBuilder1.toString());
    } 
    ErrorPath errorPath2 = ((DeserializeContext)errorPath1).errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert a value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to long");
    throw deserializeError(errorPath2, stringBuilder.toString());
  }
  
  private static String convertString(Object paramObject, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof String)
      return (String)paramObject; 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to String");
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static Timestamp convertTimestamp(Object paramObject, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof Timestamp)
      return (Timestamp)paramObject; 
    if (paramObject instanceof Date)
      return new Timestamp((Date)paramObject); 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Failed to convert value of type ");
    stringBuilder.append(paramObject.getClass().getName());
    stringBuilder.append(" to Timestamp");
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  public static <T> T convertToCustomClass(Object paramObject, Class<T> paramClass, DocumentReference paramDocumentReference) {
    return deserializeToClass(paramObject, paramClass, new DeserializeContext(ErrorPath.EMPTY, paramDocumentReference));
  }
  
  public static Object convertToPlainJavaTypes(Object paramObject) {
    return serialize(paramObject);
  }
  
  public static Map<String, Object> convertToPlainJavaTypes(Map<?, Object> paramMap) {
    Object object = serialize(paramMap);
    hardAssert(object instanceof Map);
    return (Map<String, Object>)object;
  }
  
  private static RuntimeException deserializeError(ErrorPath paramErrorPath, String paramString) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not deserialize object. ");
    stringBuilder.append(paramString);
    String str2 = stringBuilder.toString();
    paramString = str2;
    if (paramErrorPath.getLength() > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append(" (found in field '");
      stringBuilder1.append(paramErrorPath.toString());
      stringBuilder1.append("')");
      str1 = stringBuilder1.toString();
    } 
    return new RuntimeException(str1);
  }
  
  private static <T> T deserializeToClass(Object paramObject, Class<T> paramClass, DeserializeContext paramDeserializeContext) {
    StringBuilder stringBuilder;
    if (paramObject == null)
      return null; 
    if (paramClass.isPrimitive() || Number.class.isAssignableFrom(paramClass) || Boolean.class.isAssignableFrom(paramClass) || Character.class.isAssignableFrom(paramClass))
      return deserializeToPrimitive(paramObject, paramClass, paramDeserializeContext); 
    if (String.class.isAssignableFrom(paramClass))
      return (T)convertString(paramObject, paramDeserializeContext); 
    if (Date.class.isAssignableFrom(paramClass))
      return (T)convertDate(paramObject, paramDeserializeContext); 
    if (Timestamp.class.isAssignableFrom(paramClass))
      return (T)convertTimestamp(paramObject, paramDeserializeContext); 
    if (Blob.class.isAssignableFrom(paramClass))
      return (T)convertBlob(paramObject, paramDeserializeContext); 
    if (GeoPoint.class.isAssignableFrom(paramClass))
      return (T)convertGeoPoint(paramObject, paramDeserializeContext); 
    if (DocumentReference.class.isAssignableFrom(paramClass))
      return (T)convertDocumentReference(paramObject, paramDeserializeContext); 
    if (!paramClass.isArray()) {
      if ((paramClass.getTypeParameters()).length <= 0)
        return (T)(paramClass.equals(Object.class) ? paramObject : (Object)(paramClass.isEnum() ? deserializeToEnum(paramObject, paramClass, paramDeserializeContext) : convertBean(paramObject, paramClass, paramDeserializeContext))); 
      paramObject = paramDeserializeContext.errorPath;
      stringBuilder = new StringBuilder();
      stringBuilder.append("Class ");
      stringBuilder.append(paramClass.getName());
      stringBuilder.append(" has generic type parameters, please use GenericTypeIndicator instead");
      throw deserializeError(paramObject, stringBuilder.toString());
    } 
    throw deserializeError(stringBuilder.errorPath, "Converting to Arrays is not supported, please use Lists instead");
  }
  
  private static <T> T deserializeToEnum(Object paramObject, Class<T> paramClass, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof String) {
      String str = (String)paramObject;
      Field[] arrayOfField = paramClass.getFields();
      int i = arrayOfField.length;
      byte b = 0;
      while (true) {
        paramObject = str;
        if (b < i) {
          paramObject = arrayOfField[b];
          if (paramObject.isEnumConstant() && str.equals(BeanMapper.propertyName((Field)paramObject))) {
            paramObject = paramObject.getName();
            break;
          } 
          b++;
          continue;
        } 
        break;
      } 
      try {
        return (T)Enum.valueOf((Class)paramClass, (String)paramObject);
      } catch (IllegalArgumentException illegalArgumentException) {
        ErrorPath errorPath1 = paramDeserializeContext.errorPath;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find enum value of ");
        stringBuilder.append(paramClass.getName());
        stringBuilder.append(" for value \"");
        stringBuilder.append((String)paramObject);
        stringBuilder.append("\"");
        throw deserializeError(errorPath1, stringBuilder.toString());
      } 
    } 
    ErrorPath errorPath = ((DeserializeContext)stringBuilder).errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected a String while deserializing to enum ");
    stringBuilder.append(paramClass);
    stringBuilder.append(" but got a ");
    stringBuilder.append(paramObject.getClass());
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static <T> T deserializeToParameterizedType(Object<Object, Object> paramObject, ParameterizedType paramParameterizedType, DeserializeContext paramDeserializeContext) {
    StringBuilder stringBuilder;
    ErrorPath errorPath;
    ArrayList arrayList;
    Class<?> clazz = (Class)paramParameterizedType.getRawType();
    boolean bool = List.class.isAssignableFrom(clazz);
    boolean bool1 = false;
    byte b = 0;
    if (bool) {
      Type type = paramParameterizedType.getActualTypeArguments()[0];
      if (paramObject instanceof List) {
        List<Object> list = (List)paramObject;
        arrayList = new ArrayList(list.size());
        while (b < list.size()) {
          Object object = list.get(b);
          paramObject = (Object<Object, Object>)paramDeserializeContext.errorPath;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("[");
          stringBuilder1.append(b);
          stringBuilder1.append("]");
          arrayList.add(deserializeToType(object, type, paramDeserializeContext.newInstanceWithErrorPath(paramObject.child(stringBuilder1.toString()))));
          b++;
        } 
        return (T)arrayList;
      } 
      errorPath = paramDeserializeContext.errorPath;
      stringBuilder = new StringBuilder();
      stringBuilder.append("Expected a List, but got a ");
      stringBuilder.append(paramObject.getClass());
      throw deserializeError(errorPath, stringBuilder.toString());
    } 
    if (Map.class.isAssignableFrom((Class<?>)arrayList)) {
      Type type2 = stringBuilder.getActualTypeArguments()[0];
      Type type1 = stringBuilder.getActualTypeArguments()[1];
      if (type2.equals(String.class)) {
        Map<String, Object> map = expectMap(paramObject, (DeserializeContext)errorPath);
        paramObject = (Object<Object, Object>)new HashMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet())
          paramObject.put(entry.getKey(), deserializeToType(entry.getValue(), type1, errorPath.newInstanceWithErrorPath(((DeserializeContext)errorPath).errorPath.child((String)entry.getKey())))); 
        return (T)paramObject;
      } 
      paramObject = (Object<Object, Object>)((DeserializeContext)errorPath).errorPath;
      stringBuilder = new StringBuilder();
      stringBuilder.append("Only Maps with string keys are supported, but found Map with key type ");
      stringBuilder.append(type2);
      throw deserializeError(paramObject, stringBuilder.toString());
    } 
    if (!Collection.class.isAssignableFrom((Class<?>)arrayList)) {
      paramObject = (Object)expectMap(paramObject, (DeserializeContext)errorPath);
      BeanMapper<?> beanMapper = loadOrCreateBeanMapperForClass((Class<?>)arrayList);
      HashMap<Object, Object> hashMap = new HashMap<>();
      TypeVariable[] arrayOfTypeVariable = beanMapper.clazz.getTypeParameters();
      Type[] arrayOfType = stringBuilder.getActualTypeArguments();
      if (arrayOfType.length == arrayOfTypeVariable.length) {
        for (b = bool1; b < arrayOfTypeVariable.length; b++)
          hashMap.put(arrayOfTypeVariable[b], arrayOfType[b]); 
        return (T)beanMapper.deserialize((Map)paramObject, (Map)hashMap, (DeserializeContext)errorPath);
      } 
      throw new IllegalStateException("Mismatched lengths for type variables and actual types");
    } 
    throw deserializeError(errorPath.errorPath, "Collections are not supported, please use Lists instead");
  }
  
  private static <T> T deserializeToPrimitive(Object paramObject, Class<T> paramClass, DeserializeContext paramDeserializeContext) {
    if (Integer.class.isAssignableFrom(paramClass) || int.class.isAssignableFrom(paramClass))
      return (T)convertInteger(paramObject, paramDeserializeContext); 
    if (Boolean.class.isAssignableFrom(paramClass) || boolean.class.isAssignableFrom(paramClass))
      return (T)convertBoolean(paramObject, paramDeserializeContext); 
    if (Double.class.isAssignableFrom(paramClass) || double.class.isAssignableFrom(paramClass))
      return (T)convertDouble(paramObject, paramDeserializeContext); 
    if (Long.class.isAssignableFrom(paramClass) || long.class.isAssignableFrom(paramClass))
      return (T)convertLong(paramObject, paramDeserializeContext); 
    if (Float.class.isAssignableFrom(paramClass) || float.class.isAssignableFrom(paramClass))
      return (T)Float.valueOf(convertDouble(paramObject, paramDeserializeContext).floatValue()); 
    throw deserializeError(paramDeserializeContext.errorPath, String.format("Deserializing values to %s is not supported", new Object[] { paramClass.getSimpleName() }));
  }
  
  private static <T> T deserializeToType(Object paramObject, Type paramType, DeserializeContext paramDeserializeContext) {
    if (paramObject == null)
      return null; 
    if (paramType instanceof ParameterizedType)
      return deserializeToParameterizedType(paramObject, (ParameterizedType)paramType, paramDeserializeContext); 
    if (paramType instanceof Class)
      return deserializeToClass(paramObject, (Class<T>)paramType, paramDeserializeContext); 
    boolean bool = paramType instanceof WildcardType;
    boolean bool1 = true;
    boolean bool2 = true;
    if (bool) {
      WildcardType wildcardType = (WildcardType)paramType;
      if ((wildcardType.getLowerBounds()).length <= 0) {
        Type[] arrayOfType = wildcardType.getUpperBounds();
        if (arrayOfType.length <= 0)
          bool2 = false; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected type bounds on wildcard ");
        stringBuilder.append(paramType);
        hardAssert(bool2, stringBuilder.toString());
        return deserializeToType(paramObject, arrayOfType[0], paramDeserializeContext);
      } 
      throw deserializeError(paramDeserializeContext.errorPath, "Generic lower-bounded wildcard types are not supported");
    } 
    if (paramType instanceof TypeVariable) {
      Type[] arrayOfType = ((TypeVariable)paramType).getBounds();
      if (arrayOfType.length > 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unexpected type bounds on type variable ");
      stringBuilder.append(paramType);
      hardAssert(bool2, stringBuilder.toString());
      return deserializeToType(paramObject, arrayOfType[0], paramDeserializeContext);
    } 
    if (paramType instanceof java.lang.reflect.GenericArrayType)
      throw deserializeError(paramDeserializeContext.errorPath, "Generic Arrays are not supported, please use Lists instead"); 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    paramObject = new StringBuilder();
    paramObject.append("Unknown type encountered: ");
    paramObject.append(paramType);
    throw deserializeError(errorPath, paramObject.toString());
  }
  
  private static Map<String, Object> expectMap(Object paramObject, DeserializeContext paramDeserializeContext) {
    if (paramObject instanceof Map)
      return (Map<String, Object>)paramObject; 
    ErrorPath errorPath = paramDeserializeContext.errorPath;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Expected a Map while deserializing, but got a ");
    stringBuilder.append(paramObject.getClass());
    throw deserializeError(errorPath, stringBuilder.toString());
  }
  
  private static void hardAssert(boolean paramBoolean) {
    hardAssert(paramBoolean, "Internal inconsistency");
  }
  
  private static void hardAssert(boolean paramBoolean, String paramString) {
    if (paramBoolean)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Hard assert failed: ");
    stringBuilder.append(paramString);
    throw new RuntimeException(stringBuilder.toString());
  }
  
  private static <T> BeanMapper<T> loadOrCreateBeanMapperForClass(Class<T> paramClass) {
    BeanMapper<T> beanMapper1 = (BeanMapper)mappers.get(paramClass);
    BeanMapper<T> beanMapper2 = beanMapper1;
    if (beanMapper1 == null) {
      beanMapper2 = new BeanMapper<>(paramClass);
      mappers.put(paramClass, beanMapper2);
    } 
    return beanMapper2;
  }
  
  private static <T> Object serialize(T paramT) {
    return serialize(paramT, ErrorPath.EMPTY);
  }
  
  private static <T> Object serialize(T paramT, ErrorPath paramErrorPath) {
    String str;
    if (paramErrorPath.getLength() <= 500) {
      if (paramT == null)
        return null; 
      boolean bool = paramT instanceof Number;
      byte b = 0;
      if (bool) {
        if (paramT instanceof Long || paramT instanceof Integer || paramT instanceof Double || paramT instanceof Float)
          return paramT; 
        throw serializeError(paramErrorPath, String.format("Numbers of type %s are not supported, please use an int, long, float or double", new Object[] { paramT.getClass().getSimpleName() }));
      } 
      if (paramT instanceof String)
        return paramT; 
      if (paramT instanceof Boolean)
        return paramT; 
      if (!(paramT instanceof Character)) {
        ArrayList<Object> arrayList;
        if (paramT instanceof Map) {
          HashMap<Object, Object> hashMap = new HashMap<>();
          for (Map.Entry entry : ((Map)paramT).entrySet()) {
            Object object = entry.getKey();
            if (object instanceof String) {
              object = object;
              hashMap.put(object, serialize(entry.getValue(), paramErrorPath.child((String)object)));
              continue;
            } 
            throw serializeError(paramErrorPath, "Maps with non-string keys are not supported");
          } 
          return hashMap;
        } 
        if (paramT instanceof Collection) {
          if (paramT instanceof List) {
            List<Object> list = (List)paramT;
            arrayList = new ArrayList(list.size());
            while (b < list.size()) {
              Object object = list.get(b);
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("[");
              stringBuilder.append(b);
              stringBuilder.append("]");
              arrayList.add(serialize(object, paramErrorPath.child(stringBuilder.toString())));
              b++;
            } 
            return arrayList;
          } 
          throw serializeError(paramErrorPath, "Serializing Collections is not supported, please use Lists instead");
        } 
        if (!arrayList.getClass().isArray()) {
          Map<String, Object> map;
          if (arrayList instanceof Enum) {
            str = ((Enum)arrayList).name();
            try {
              return BeanMapper.propertyName(arrayList.getClass().getField(str));
            } catch (NoSuchFieldException noSuchFieldException1) {
              return str;
            } 
          } 
          NoSuchFieldException noSuchFieldException2 = noSuchFieldException1;
          if (!(noSuchFieldException1 instanceof Date)) {
            noSuchFieldException2 = noSuchFieldException1;
            if (!(noSuchFieldException1 instanceof Timestamp)) {
              noSuchFieldException2 = noSuchFieldException1;
              if (!(noSuchFieldException1 instanceof GeoPoint)) {
                noSuchFieldException2 = noSuchFieldException1;
                if (!(noSuchFieldException1 instanceof Blob)) {
                  noSuchFieldException2 = noSuchFieldException1;
                  if (!(noSuchFieldException1 instanceof DocumentReference))
                    if (noSuchFieldException1 instanceof com.google.firebase.firestore.FieldValue) {
                      noSuchFieldException2 = noSuchFieldException1;
                    } else {
                      map = loadOrCreateBeanMapperForClass(noSuchFieldException1.getClass()).serialize(noSuchFieldException1, (ErrorPath)str);
                    }  
                } 
              } 
            } 
          } 
          return map;
        } 
        throw serializeError(str, "Serializing Arrays is not supported, please use Lists instead");
      } 
      throw serializeError(str, "Characters are not supported, please use Strings");
    } 
    throw serializeError(str, "Exceeded maximum depth of 500, which likely indicates there's an object cycle");
  }
  
  private static IllegalArgumentException serializeError(ErrorPath paramErrorPath, String paramString) {
    String str1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Could not serialize object. ");
    stringBuilder.append(paramString);
    String str2 = stringBuilder.toString();
    paramString = str2;
    if (paramErrorPath.getLength() > 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str2);
      stringBuilder1.append(" (found in field '");
      stringBuilder1.append(paramErrorPath.toString());
      stringBuilder1.append("')");
      str1 = stringBuilder1.toString();
    } 
    return new IllegalArgumentException(str1);
  }
  
  private static class BeanMapper<T> {
    private final Class<T> clazz;
    
    private final Constructor<T> constructor;
    
    private final HashSet<String> documentIdPropertyNames;
    
    private final Map<String, Field> fields;
    
    private final Map<String, Method> getters;
    
    private final Map<String, String> properties;
    
    private final HashSet<String> serverTimestamps;
    
    private final Map<String, Method> setters;
    
    private final boolean throwOnUnknownProperties;
    
    private final boolean warnOnUnknownProperties;
    
    BeanMapper(Class<T> param1Class) {
      StringBuilder stringBuilder1;
      this.clazz = param1Class;
      this.throwOnUnknownProperties = param1Class.isAnnotationPresent((Class)ThrowOnExtraProperties.class);
      this.warnOnUnknownProperties = param1Class.isAnnotationPresent((Class)IgnoreExtraProperties.class) ^ true;
      this.properties = new HashMap<>();
      this.setters = new HashMap<>();
      this.getters = new HashMap<>();
      this.fields = new HashMap<>();
      this.serverTimestamps = new HashSet<>();
      this.documentIdPropertyNames = new HashSet<>();
      try {
        Constructor<T> constructor = param1Class.getDeclaredConstructor(new Class[0]);
        constructor.setAccessible(true);
      } catch (NoSuchMethodException noSuchMethodException) {
        noSuchMethodException = null;
      } 
      this.constructor = (Constructor<T>)noSuchMethodException;
      for (Method method : param1Class.getMethods()) {
        if (shouldIncludeGetter(method)) {
          String str = propertyName(method);
          addProperty(str);
          method.setAccessible(true);
          if (!this.getters.containsKey(str)) {
            this.getters.put(str, method);
            applyGetterAnnotations(method);
          } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Found conflicting getters for name ");
            stringBuilder.append(method.getName());
            stringBuilder.append(" on class ");
            stringBuilder.append(param1Class.getName());
            throw new RuntimeException(stringBuilder.toString());
          } 
        } 
      } 
      for (Field field : param1Class.getFields()) {
        if (shouldIncludeField(field)) {
          addProperty(propertyName(field));
          applyFieldAnnotations(field);
        } 
      } 
      Class<T> clazz = param1Class;
      while (true) {
        StringBuilder stringBuilder;
        for (Method method : clazz.getDeclaredMethods()) {
          if (shouldIncludeSetter(method)) {
            String str1 = propertyName(method);
            String str2 = this.properties.get(str1.toLowerCase(Locale.US));
            if (str2 != null)
              if (str2.equals(str1)) {
                Method method1 = this.setters.get(str1);
                if (method1 == null) {
                  method.setAccessible(true);
                  this.setters.put(str1, method);
                  applySetterAnnotations(method);
                } else if (!isSetterOverride(method, method1)) {
                  if (clazz == param1Class) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Class ");
                    stringBuilder.append(param1Class.getName());
                    stringBuilder.append(" has multiple setter overloads with name ");
                    stringBuilder.append(method.getName());
                    throw new RuntimeException(stringBuilder.toString());
                  } 
                  stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("Found conflicting setters with name: ");
                  stringBuilder1.append(method.getName());
                  stringBuilder1.append(" (conflicts with ");
                  stringBuilder1.append(method1.getName());
                  stringBuilder1.append(" defined on ");
                  stringBuilder1.append(method1.getDeclaringClass().getName());
                  stringBuilder1.append(")");
                  throw new RuntimeException(stringBuilder1.toString());
                } 
              } else {
                stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Found setter on ");
                stringBuilder1.append(stringBuilder.getName());
                stringBuilder1.append(" with invalid case-sensitive name: ");
                stringBuilder1.append(method.getName());
                throw new RuntimeException(stringBuilder1.toString());
              }  
          } 
        } 
        for (Field field : stringBuilder.getDeclaredFields()) {
          String str = propertyName(field);
          if (this.properties.containsKey(str.toLowerCase(Locale.US)) && !this.fields.containsKey(str)) {
            field.setAccessible(true);
            this.fields.put(str, field);
            applyFieldAnnotations(field);
          } 
        } 
        Class clazz1 = stringBuilder.getSuperclass();
        if (clazz1 != null) {
          Class clazz2 = clazz1;
          if (clazz1.equals(Object.class))
            break; 
          continue;
        } 
        break;
      } 
      if (!this.properties.isEmpty()) {
        Iterator<String> iterator = this.documentIdPropertyNames.iterator();
        while (iterator.hasNext()) {
          String str = iterator.next();
          if (this.setters.containsKey(str) || this.fields.containsKey(str))
            continue; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("@DocumentId is annotated on property ");
          stringBuilder.append(str);
          stringBuilder.append(" of class ");
          stringBuilder.append(stringBuilder1.getName());
          stringBuilder.append(" but no field or public setter was found");
          throw new RuntimeException(stringBuilder.toString());
        } 
        return;
      } 
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("No properties to serialize found on class ");
      stringBuilder2.append(stringBuilder1.getName());
      throw new RuntimeException(stringBuilder2.toString());
    }
    
    private void addProperty(String param1String) {
      String str = this.properties.put(param1String.toLowerCase(Locale.US), param1String);
      if (str == null || param1String.equals(str))
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Found two getters or fields with conflicting case sensitivity for property: ");
      stringBuilder.append(param1String.toLowerCase(Locale.US));
      throw new RuntimeException(stringBuilder.toString());
    }
    
    private static String annotatedName(AccessibleObject param1AccessibleObject) {
      return param1AccessibleObject.isAnnotationPresent((Class)PropertyName.class) ? ((PropertyName)param1AccessibleObject.<PropertyName>getAnnotation(PropertyName.class)).value() : null;
    }
    
    private void applyFieldAnnotations(Field param1Field) {
      if (param1Field.isAnnotationPresent((Class)ServerTimestamp.class)) {
        Class<?> clazz = param1Field.getType();
        if (clazz == Date.class || clazz == Timestamp.class) {
          this.serverTimestamps.add(propertyName(param1Field));
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Field ");
          stringBuilder.append(param1Field.getName());
          stringBuilder.append(" is annotated with @ServerTimestamp but is ");
          stringBuilder.append(clazz);
          stringBuilder.append(" instead of Date or Timestamp.");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } 
      if (param1Field.isAnnotationPresent((Class)DocumentId.class)) {
        ensureValidDocumentIdType("Field", "is", param1Field.getType());
        this.documentIdPropertyNames.add(propertyName(param1Field));
      } 
    }
    
    private void applyGetterAnnotations(Method param1Method) {
      if (param1Method.isAnnotationPresent((Class)ServerTimestamp.class)) {
        Class<?> clazz = param1Method.getReturnType();
        if (clazz == Date.class || clazz == Timestamp.class) {
          this.serverTimestamps.add(propertyName(param1Method));
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Method ");
          stringBuilder.append(param1Method.getName());
          stringBuilder.append(" is annotated with @ServerTimestamp but returns ");
          stringBuilder.append(clazz);
          stringBuilder.append(" instead of Date or Timestamp.");
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } 
      if (param1Method.isAnnotationPresent((Class)DocumentId.class)) {
        ensureValidDocumentIdType("Method", "returns", param1Method.getReturnType());
        this.documentIdPropertyNames.add(propertyName(param1Method));
      } 
    }
    
    private void applySetterAnnotations(Method param1Method) {
      if (!param1Method.isAnnotationPresent((Class)ServerTimestamp.class)) {
        if (param1Method.isAnnotationPresent((Class)DocumentId.class)) {
          ensureValidDocumentIdType("Method", "accepts", param1Method.getParameterTypes()[0]);
          this.documentIdPropertyNames.add(propertyName(param1Method));
        } 
        return;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Method ");
      stringBuilder.append(param1Method.getName());
      stringBuilder.append(" is annotated with @ServerTimestamp but should not be. @ServerTimestamp can only be applied to fields and getters, not setters.");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    private void ensureValidDocumentIdType(String param1String1, String param1String2, Type param1Type) {
      if (param1Type == String.class || param1Type == DocumentReference.class)
        return; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1String1);
      stringBuilder.append(" is annotated with @DocumentId but ");
      stringBuilder.append(param1String2);
      stringBuilder.append(" ");
      stringBuilder.append(param1Type);
      stringBuilder.append(" instead of String or DocumentReference.");
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    private static boolean isSetterOverride(Method param1Method1, Method param1Method2) {
      CustomClassMapper.hardAssert(param1Method1.getDeclaringClass().isAssignableFrom(param1Method2.getDeclaringClass()), "Expected override from a base class");
      CustomClassMapper.hardAssert(param1Method1.getReturnType().equals(void.class), "Expected void return type");
      CustomClassMapper.hardAssert(param1Method2.getReturnType().equals(void.class), "Expected void return type");
      Class[] arrayOfClass1 = param1Method1.getParameterTypes();
      Class[] arrayOfClass2 = param1Method2.getParameterTypes();
      int i = arrayOfClass1.length;
      boolean bool1 = false;
      if (i == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      CustomClassMapper.hardAssert(bool2, "Expected exactly one parameter");
      if (arrayOfClass2.length == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      } 
      CustomClassMapper.hardAssert(bool2, "Expected exactly one parameter");
      boolean bool2 = bool1;
      if (param1Method1.getName().equals(param1Method2.getName())) {
        bool2 = bool1;
        if (arrayOfClass1[0].equals(arrayOfClass2[0]))
          bool2 = true; 
      } 
      return bool2;
    }
    
    private void populateDocumentIdProperties(Map<TypeVariable<Class<T>>, Type> param1Map, CustomClassMapper.DeserializeContext param1DeserializeContext, T param1T, HashSet<String> param1HashSet) {
      for (String str : this.documentIdPropertyNames) {
        Type[] arrayOfType;
        if (!param1HashSet.contains(str)) {
          CustomClassMapper.ErrorPath errorPath = param1DeserializeContext.errorPath.child(str);
          if (this.setters.containsKey(str)) {
            Method method = this.setters.get(str);
            arrayOfType = method.getGenericParameterTypes();
            if (arrayOfType.length == 1) {
              if (resolveType(arrayOfType[0], param1Map) == String.class) {
                ApiUtil.invoke(method, param1T, new Object[] { param1DeserializeContext.documentRef.getId() });
                continue;
              } 
              ApiUtil.invoke(method, param1T, new Object[] { param1DeserializeContext.documentRef });
              continue;
            } 
            throw CustomClassMapper.deserializeError(errorPath, "Setter does not have exactly one parameter");
          } 
          Field field = this.fields.get(arrayOfType);
          try {
            if (field.getType() == String.class) {
              field.set(param1T, param1DeserializeContext.documentRef.getId());
              continue;
            } 
            field.set(param1T, param1DeserializeContext.documentRef);
          } catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
          } 
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("'");
        stringBuilder.append((String)arrayOfType);
        stringBuilder.append("' was found from document ");
        stringBuilder.append(param1DeserializeContext.documentRef.getPath());
        stringBuilder.append(", cannot apply @DocumentId on this property for class ");
        stringBuilder.append(this.clazz.getName());
        throw new RuntimeException(stringBuilder.toString());
      } 
    }
    
    private static String propertyName(Field param1Field) {
      String str1;
      String str2 = annotatedName(param1Field);
      if (str2 != null) {
        str1 = str2;
      } else {
        str1 = str1.getName();
      } 
      return str1;
    }
    
    private static String propertyName(Method param1Method) {
      String str1;
      String str2 = annotatedName(param1Method);
      if (str2 != null) {
        str1 = str2;
      } else {
        str1 = serializedName(str1.getName());
      } 
      return str1;
    }
    
    private Type resolveType(Type param1Type, Map<TypeVariable<Class<T>>, Type> param1Map) {
      if (param1Type instanceof TypeVariable) {
        Type type = param1Map.get(param1Type);
        if (type != null)
          return type; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Could not resolve type ");
        stringBuilder.append(param1Type);
        throw new IllegalStateException(stringBuilder.toString());
      } 
      return param1Type;
    }
    
    private static String serializedName(String param1String) {
      char[] arrayOfChar;
      String[] arrayOfString = new String[3];
      arrayOfString[0] = "get";
      arrayOfString[1] = "set";
      arrayOfString[2] = "is";
      int i = arrayOfString.length;
      boolean bool = false;
      String str = null;
      byte b;
      for (b = 0; b < i; b++) {
        String str1 = arrayOfString[b];
        if (param1String.startsWith(str1))
          str = str1; 
      } 
      if (str != null) {
        arrayOfChar = param1String.substring(str.length()).toCharArray();
        for (b = bool; b < arrayOfChar.length && Character.isUpperCase(arrayOfChar[b]); b++)
          arrayOfChar[b] = Character.toLowerCase(arrayOfChar[b]); 
        return new String(arrayOfChar);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unknown Bean prefix for method: ");
      stringBuilder.append((String)arrayOfChar);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    private static boolean shouldIncludeField(Field param1Field) {
      return param1Field.getDeclaringClass().equals(Object.class) ? false : (!Modifier.isPublic(param1Field.getModifiers()) ? false : (Modifier.isStatic(param1Field.getModifiers()) ? false : (Modifier.isTransient(param1Field.getModifiers()) ? false : (!param1Field.isAnnotationPresent((Class)Exclude.class)))));
    }
    
    private static boolean shouldIncludeGetter(Method param1Method) {
      return (!param1Method.getName().startsWith("get") && !param1Method.getName().startsWith("is")) ? false : (param1Method.getDeclaringClass().equals(Object.class) ? false : (!Modifier.isPublic(param1Method.getModifiers()) ? false : (Modifier.isStatic(param1Method.getModifiers()) ? false : (param1Method.getReturnType().equals(void.class) ? false : (((param1Method.getParameterTypes()).length != 0) ? false : (!param1Method.isAnnotationPresent((Class)Exclude.class)))))));
    }
    
    private static boolean shouldIncludeSetter(Method param1Method) {
      return !param1Method.getName().startsWith("set") ? false : (param1Method.getDeclaringClass().equals(Object.class) ? false : (Modifier.isStatic(param1Method.getModifiers()) ? false : (!param1Method.getReturnType().equals(void.class) ? false : (((param1Method.getParameterTypes()).length != 1) ? false : (!param1Method.isAnnotationPresent((Class)Exclude.class))))));
    }
    
    T deserialize(Map<String, Object> param1Map, CustomClassMapper.DeserializeContext param1DeserializeContext) {
      return deserialize(param1Map, Collections.emptyMap(), param1DeserializeContext);
    }
    
    T deserialize(Map<String, Object> param1Map, Map<TypeVariable<Class<T>>, Type> param1Map1, CustomClassMapper.DeserializeContext param1DeserializeContext) {
      Constructor<T> constructor = this.constructor;
      if (constructor != null) {
        T t = (T)ApiUtil.newInstance((Constructor)constructor);
        HashSet<String> hashSet = new HashSet();
        for (Map.Entry<String, Object> entry : param1Map.entrySet()) {
          String str3 = (String)entry.getKey();
          CustomClassMapper.ErrorPath errorPath1 = param1DeserializeContext.errorPath.child(str3);
          if (this.setters.containsKey(str3)) {
            Method method = this.setters.get(str3);
            Type[] arrayOfType = method.getGenericParameterTypes();
            if (arrayOfType.length == 1) {
              Type type = resolveType(arrayOfType[0], param1Map1);
              ApiUtil.invoke(method, t, new Object[] { CustomClassMapper.access$300(entry.getValue(), type, param1DeserializeContext.newInstanceWithErrorPath(errorPath1)) });
              hashSet.add(str3);
              continue;
            } 
            throw CustomClassMapper.deserializeError(errorPath1, "Setter does not have exactly one parameter");
          } 
          if (this.fields.containsKey(str3)) {
            Field field = this.fields.get(str3);
            Type type = resolveType(field.getGenericType(), param1Map1);
            Object object = CustomClassMapper.deserializeToType(entry.getValue(), type, param1DeserializeContext.newInstanceWithErrorPath(errorPath1));
            try {
              field.set(t, object);
              hashSet.add(str3);
            } catch (IllegalAccessException illegalAccessException) {
              throw new RuntimeException(illegalAccessException);
            } 
            continue;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("No setter/field for ");
          stringBuilder1.append(str3);
          stringBuilder1.append(" found on class ");
          stringBuilder1.append(this.clazz.getName());
          String str2 = stringBuilder1.toString();
          String str1 = str2;
          if (this.properties.containsKey(str3.toLowerCase(Locale.US))) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append(" (fields/setters are case sensitive!)");
            str1 = stringBuilder2.toString();
          } 
          if (!this.throwOnUnknownProperties) {
            if (this.warnOnUnknownProperties)
              Logger.warn(CustomClassMapper.class.getSimpleName(), "%s", new Object[] { str1 }); 
            continue;
          } 
          throw new RuntimeException(str1);
        } 
        populateDocumentIdProperties(param1Map1, param1DeserializeContext, t, hashSet);
        return t;
      } 
      CustomClassMapper.ErrorPath errorPath = param1DeserializeContext.errorPath;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Class ");
      stringBuilder.append(this.clazz.getName());
      stringBuilder.append(" does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped");
      throw CustomClassMapper.deserializeError(errorPath, stringBuilder.toString());
    }
    
    Map<String, Object> serialize(T param1T, CustomClassMapper.ErrorPath param1ErrorPath) {
      // Byte code:
      //   0: aload_0
      //   1: getfield clazz : Ljava/lang/Class;
      //   4: aload_1
      //   5: invokevirtual getClass : ()Ljava/lang/Class;
      //   8: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
      //   11: ifeq -> 244
      //   14: new java/util/HashMap
      //   17: dup
      //   18: invokespecial <init> : ()V
      //   21: astore_3
      //   22: aload_0
      //   23: getfield properties : Ljava/util/Map;
      //   26: invokeinterface values : ()Ljava/util/Collection;
      //   31: invokeinterface iterator : ()Ljava/util/Iterator;
      //   36: astore #4
      //   38: aload #4
      //   40: invokeinterface hasNext : ()Z
      //   45: ifeq -> 242
      //   48: aload #4
      //   50: invokeinterface next : ()Ljava/lang/Object;
      //   55: checkcast java/lang/String
      //   58: astore #5
      //   60: aload_0
      //   61: getfield documentIdPropertyNames : Ljava/util/HashSet;
      //   64: aload #5
      //   66: invokevirtual contains : (Ljava/lang/Object;)Z
      //   69: ifeq -> 75
      //   72: goto -> 38
      //   75: aload_0
      //   76: getfield getters : Ljava/util/Map;
      //   79: aload #5
      //   81: invokeinterface containsKey : (Ljava/lang/Object;)Z
      //   86: ifeq -> 116
      //   89: aload_0
      //   90: getfield getters : Ljava/util/Map;
      //   93: aload #5
      //   95: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   100: checkcast java/lang/reflect/Method
      //   103: aload_1
      //   104: iconst_0
      //   105: anewarray java/lang/Object
      //   108: invokestatic invoke : (Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   111: astore #6
      //   113: goto -> 145
      //   116: aload_0
      //   117: getfield fields : Ljava/util/Map;
      //   120: aload #5
      //   122: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   127: checkcast java/lang/reflect/Field
      //   130: astore #6
      //   132: aload #6
      //   134: ifnull -> 207
      //   137: aload #6
      //   139: aload_1
      //   140: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   143: astore #6
      //   145: aload_0
      //   146: getfield serverTimestamps : Ljava/util/HashSet;
      //   149: aload #5
      //   151: invokevirtual contains : (Ljava/lang/Object;)Z
      //   154: ifeq -> 170
      //   157: aload #6
      //   159: ifnonnull -> 170
      //   162: invokestatic serverTimestamp : ()Lcom/google/firebase/firestore/FieldValue;
      //   165: astore #6
      //   167: goto -> 183
      //   170: aload #6
      //   172: aload_2
      //   173: aload #5
      //   175: invokevirtual child : (Ljava/lang/String;)Lcom/google/firebase/firestore/util/CustomClassMapper$ErrorPath;
      //   178: invokestatic access$400 : (Ljava/lang/Object;Lcom/google/firebase/firestore/util/CustomClassMapper$ErrorPath;)Ljava/lang/Object;
      //   181: astore #6
      //   183: aload_3
      //   184: aload #5
      //   186: aload #6
      //   188: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   193: pop
      //   194: goto -> 38
      //   197: astore_1
      //   198: new java/lang/RuntimeException
      //   201: dup
      //   202: aload_1
      //   203: invokespecial <init> : (Ljava/lang/Throwable;)V
      //   206: athrow
      //   207: new java/lang/StringBuilder
      //   210: dup
      //   211: invokespecial <init> : ()V
      //   214: astore_1
      //   215: aload_1
      //   216: ldc_w 'Bean property without field or getter: '
      //   219: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   222: pop
      //   223: aload_1
      //   224: aload #5
      //   226: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   229: pop
      //   230: new java/lang/IllegalStateException
      //   233: dup
      //   234: aload_1
      //   235: invokevirtual toString : ()Ljava/lang/String;
      //   238: invokespecial <init> : (Ljava/lang/String;)V
      //   241: athrow
      //   242: aload_3
      //   243: areturn
      //   244: new java/lang/StringBuilder
      //   247: dup
      //   248: invokespecial <init> : ()V
      //   251: astore_2
      //   252: aload_2
      //   253: ldc_w 'Can't serialize object of class '
      //   256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   259: pop
      //   260: aload_2
      //   261: aload_1
      //   262: invokevirtual getClass : ()Ljava/lang/Class;
      //   265: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   268: pop
      //   269: aload_2
      //   270: ldc_w ' with BeanMapper for class '
      //   273: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   276: pop
      //   277: aload_2
      //   278: aload_0
      //   279: getfield clazz : Ljava/lang/Class;
      //   282: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   285: pop
      //   286: new java/lang/IllegalArgumentException
      //   289: dup
      //   290: aload_2
      //   291: invokevirtual toString : ()Ljava/lang/String;
      //   294: invokespecial <init> : (Ljava/lang/String;)V
      //   297: athrow
      // Exception table:
      //   from	to	target	type
      //   137	145	197	java/lang/IllegalAccessException
    }
  }
  
  static class DeserializeContext {
    final DocumentReference documentRef;
    
    final CustomClassMapper.ErrorPath errorPath;
    
    DeserializeContext(CustomClassMapper.ErrorPath param1ErrorPath, DocumentReference param1DocumentReference) {
      this.errorPath = param1ErrorPath;
      this.documentRef = param1DocumentReference;
    }
    
    DeserializeContext newInstanceWithErrorPath(CustomClassMapper.ErrorPath param1ErrorPath) {
      return new DeserializeContext(param1ErrorPath, this.documentRef);
    }
  }
  
  static class ErrorPath {
    static final ErrorPath EMPTY = new ErrorPath(null, null, 0);
    
    private final int length;
    
    private final String name;
    
    private final ErrorPath parent;
    
    ErrorPath(ErrorPath param1ErrorPath, String param1String, int param1Int) {
      this.parent = param1ErrorPath;
      this.name = param1String;
      this.length = param1Int;
    }
    
    ErrorPath child(String param1String) {
      return new ErrorPath(this, param1String, this.length + 1);
    }
    
    int getLength() {
      return this.length;
    }
    
    public String toString() {
      int i = this.length;
      if (i == 0)
        return ""; 
      if (i == 1)
        return this.name; 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.parent.toString());
      stringBuilder.append(".");
      stringBuilder.append(this.name);
      return stringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestor\\util\CustomClassMapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */