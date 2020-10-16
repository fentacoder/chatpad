package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.DocumentSet;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class View {
  private boolean current;
  
  private DocumentSet documentSet;
  
  private ImmutableSortedSet<DocumentKey> limboDocuments;
  
  private ImmutableSortedSet<DocumentKey> mutatedKeys;
  
  private final Query query;
  
  private ViewSnapshot.SyncState syncState;
  
  private ImmutableSortedSet<DocumentKey> syncedDocuments;
  
  public View(Query paramQuery, ImmutableSortedSet<DocumentKey> paramImmutableSortedSet) {
    this.query = paramQuery;
    this.syncState = ViewSnapshot.SyncState.NONE;
    this.documentSet = DocumentSet.emptySet(paramQuery.comparator());
    this.syncedDocuments = paramImmutableSortedSet;
    this.limboDocuments = DocumentKey.emptyKeySet();
    this.mutatedKeys = DocumentKey.emptyKeySet();
  }
  
  private void applyTargetChange(TargetChange paramTargetChange) {
    if (paramTargetChange != null) {
      for (DocumentKey documentKey : paramTargetChange.getAddedDocuments())
        this.syncedDocuments = this.syncedDocuments.insert(documentKey); 
      for (DocumentKey documentKey : paramTargetChange.getModifiedDocuments()) {
        Assert.hardAssert(this.syncedDocuments.contains(documentKey), "Modified document %s not found in view.", new Object[] { documentKey });
      } 
      for (DocumentKey documentKey : paramTargetChange.getRemovedDocuments())
        this.syncedDocuments = this.syncedDocuments.remove(documentKey); 
      this.current = paramTargetChange.isCurrent();
    } 
  }
  
  private static int changeTypeOrder(DocumentViewChange paramDocumentViewChange) {
    int i = null.$SwitchMap$com$google$firebase$firestore$core$DocumentViewChange$Type[paramDocumentViewChange.getType().ordinal()];
    byte b = 1;
    if (i != 1) {
      byte b1 = 2;
      b = b1;
      if (i != 2) {
        b = b1;
        if (i != 3) {
          if (i == 4)
            return 0; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Unknown change type: ");
          stringBuilder.append(paramDocumentViewChange.getType());
          throw new IllegalArgumentException(stringBuilder.toString());
        } 
      } 
    } 
    return b;
  }
  
  private boolean shouldBeLimboDoc(DocumentKey paramDocumentKey) {
    if (this.syncedDocuments.contains(paramDocumentKey))
      return false; 
    Document document = this.documentSet.getDocument(paramDocumentKey);
    return (document == null) ? false : (!document.hasLocalMutations());
  }
  
  private boolean shouldWaitForSyncedDocument(Document paramDocument1, Document paramDocument2) {
    boolean bool;
    if (paramDocument1.hasLocalMutations() && paramDocument2.hasCommittedMutations() && !paramDocument2.hasLocalMutations()) {
      bool = true;
    } else {
      bool = false;
    } 
    return bool;
  }
  
  private List<LimboDocumentChange> updateLimboDocuments() {
    if (!this.current)
      return Collections.emptyList(); 
    ImmutableSortedSet<DocumentKey> immutableSortedSet = this.limboDocuments;
    this.limboDocuments = DocumentKey.emptyKeySet();
    for (Document document : this.documentSet) {
      if (shouldBeLimboDoc(document.getKey()))
        this.limboDocuments = this.limboDocuments.insert(document.getKey()); 
    } 
    ArrayList<LimboDocumentChange> arrayList = new ArrayList(immutableSortedSet.size() + this.limboDocuments.size());
    for (DocumentKey documentKey : immutableSortedSet) {
      if (!this.limboDocuments.contains(documentKey))
        arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.REMOVED, documentKey)); 
    } 
    for (DocumentKey documentKey : this.limboDocuments) {
      if (!immutableSortedSet.contains(documentKey))
        arrayList.add(new LimboDocumentChange(LimboDocumentChange.Type.ADDED, documentKey)); 
    } 
    return arrayList;
  }
  
  public ViewChange applyChanges(DocumentChanges paramDocumentChanges) {
    return applyChanges(paramDocumentChanges, null);
  }
  
  public ViewChange applyChanges(DocumentChanges paramDocumentChanges, TargetChange paramTargetChange) {
    ViewSnapshot.SyncState syncState;
    boolean bool1;
    boolean bool2;
    Assert.hardAssert(paramDocumentChanges.needsRefill ^ true, "Cannot apply changes that need a refill", new Object[0]);
    DocumentSet documentSet = this.documentSet;
    this.documentSet = paramDocumentChanges.documentSet;
    this.mutatedKeys = paramDocumentChanges.mutatedKeys;
    List<DocumentViewChange> list = paramDocumentChanges.changeSet.getChanges();
    Collections.sort(list, View$$Lambda$1.lambdaFactory$(this));
    applyTargetChange(paramTargetChange);
    List<LimboDocumentChange> list1 = updateLimboDocuments();
    if (this.limboDocuments.size() == 0 && this.current) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (bool1) {
      syncState = ViewSnapshot.SyncState.SYNCED;
    } else {
      syncState = ViewSnapshot.SyncState.LOCAL;
    } 
    if (syncState != this.syncState) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    this.syncState = syncState;
    if (list.size() != 0 || bool2) {
      boolean bool;
      if (syncState == ViewSnapshot.SyncState.LOCAL) {
        bool = true;
      } else {
        bool = false;
      } 
      ViewSnapshot viewSnapshot = new ViewSnapshot(this.query, paramDocumentChanges.documentSet, documentSet, list, bool, paramDocumentChanges.mutatedKeys, bool2, false);
      return new ViewChange(viewSnapshot, list1);
    } 
    paramDocumentChanges = null;
    return new ViewChange((ViewSnapshot)paramDocumentChanges, list1);
  }
  
  public ViewChange applyOnlineStateChange(OnlineState paramOnlineState) {
    if (this.current && paramOnlineState == OnlineState.OFFLINE) {
      this.current = false;
      return applyChanges(new DocumentChanges(this.documentSet, new DocumentViewChangeSet(), this.mutatedKeys, false));
    } 
    return new ViewChange(null, Collections.emptyList());
  }
  
  public <D extends com.google.firebase.firestore.model.MaybeDocument> DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, D> paramImmutableSortedMap) {
    return computeDocChanges(paramImmutableSortedMap, null);
  }
  
  public <D extends com.google.firebase.firestore.model.MaybeDocument> DocumentChanges computeDocChanges(ImmutableSortedMap<DocumentKey, D> paramImmutableSortedMap, DocumentChanges paramDocumentChanges) {
    // Byte code:
    //   0: aload_2
    //   1: ifnull -> 12
    //   4: aload_2
    //   5: getfield changeSet : Lcom/google/firebase/firestore/core/DocumentViewChangeSet;
    //   8: astore_3
    //   9: goto -> 20
    //   12: new com/google/firebase/firestore/core/DocumentViewChangeSet
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore_3
    //   20: aload_2
    //   21: ifnull -> 33
    //   24: aload_2
    //   25: getfield documentSet : Lcom/google/firebase/firestore/model/DocumentSet;
    //   28: astore #4
    //   30: goto -> 39
    //   33: aload_0
    //   34: getfield documentSet : Lcom/google/firebase/firestore/model/DocumentSet;
    //   37: astore #4
    //   39: aload_2
    //   40: ifnull -> 52
    //   43: aload_2
    //   44: getfield mutatedKeys : Lcom/google/firebase/database/collection/ImmutableSortedSet;
    //   47: astore #5
    //   49: goto -> 58
    //   52: aload_0
    //   53: getfield mutatedKeys : Lcom/google/firebase/database/collection/ImmutableSortedSet;
    //   56: astore #5
    //   58: aload_0
    //   59: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   62: invokevirtual hasLimitToFirst : ()Z
    //   65: ifeq -> 95
    //   68: aload #4
    //   70: invokevirtual size : ()I
    //   73: i2l
    //   74: aload_0
    //   75: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   78: invokevirtual getLimitToFirst : ()J
    //   81: lcmp
    //   82: ifne -> 95
    //   85: aload #4
    //   87: invokevirtual getLastDocument : ()Lcom/google/firebase/firestore/model/Document;
    //   90: astore #6
    //   92: goto -> 98
    //   95: aconst_null
    //   96: astore #6
    //   98: aload_0
    //   99: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   102: invokevirtual hasLimitToLast : ()Z
    //   105: ifeq -> 135
    //   108: aload #4
    //   110: invokevirtual size : ()I
    //   113: i2l
    //   114: aload_0
    //   115: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   118: invokevirtual getLimitToLast : ()J
    //   121: lcmp
    //   122: ifne -> 135
    //   125: aload #4
    //   127: invokevirtual getFirstDocument : ()Lcom/google/firebase/firestore/model/Document;
    //   130: astore #7
    //   132: goto -> 138
    //   135: aconst_null
    //   136: astore #7
    //   138: aload_1
    //   139: invokevirtual iterator : ()Ljava/util/Iterator;
    //   142: astore #8
    //   144: aload #5
    //   146: astore_1
    //   147: iconst_0
    //   148: istore #9
    //   150: aload #4
    //   152: astore #5
    //   154: aload #4
    //   156: astore #10
    //   158: aload #8
    //   160: invokeinterface hasNext : ()Z
    //   165: ifeq -> 684
    //   168: aload #8
    //   170: invokeinterface next : ()Ljava/lang/Object;
    //   175: checkcast java/util/Map$Entry
    //   178: astore #4
    //   180: aload #4
    //   182: invokeinterface getKey : ()Ljava/lang/Object;
    //   187: checkcast com/google/firebase/firestore/model/DocumentKey
    //   190: astore #11
    //   192: aload #10
    //   194: aload #11
    //   196: invokevirtual getDocument : (Lcom/google/firebase/firestore/model/DocumentKey;)Lcom/google/firebase/firestore/model/Document;
    //   199: astore #12
    //   201: aload #4
    //   203: invokeinterface getValue : ()Ljava/lang/Object;
    //   208: checkcast com/google/firebase/firestore/model/MaybeDocument
    //   211: astore #4
    //   213: aload #4
    //   215: instanceof com/google/firebase/firestore/model/Document
    //   218: ifeq -> 231
    //   221: aload #4
    //   223: checkcast com/google/firebase/firestore/model/Document
    //   226: astore #4
    //   228: goto -> 234
    //   231: aconst_null
    //   232: astore #4
    //   234: aload #4
    //   236: ifnull -> 294
    //   239: aload #11
    //   241: aload #4
    //   243: invokevirtual getKey : ()Lcom/google/firebase/firestore/model/DocumentKey;
    //   246: invokevirtual equals : (Ljava/lang/Object;)Z
    //   249: ldc_w 'Mismatching key in doc change %s != %s'
    //   252: iconst_2
    //   253: anewarray java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload #11
    //   260: aastore
    //   261: dup
    //   262: iconst_1
    //   263: aload #4
    //   265: invokevirtual getKey : ()Lcom/google/firebase/firestore/model/DocumentKey;
    //   268: aastore
    //   269: invokestatic hardAssert : (ZLjava/lang/String;[Ljava/lang/Object;)V
    //   272: aload #4
    //   274: astore #13
    //   276: aload_0
    //   277: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   280: aload #4
    //   282: invokevirtual matches : (Lcom/google/firebase/firestore/model/Document;)Z
    //   285: ifne -> 298
    //   288: aconst_null
    //   289: astore #13
    //   291: goto -> 298
    //   294: aload #4
    //   296: astore #13
    //   298: iconst_1
    //   299: istore #14
    //   301: aload #12
    //   303: ifnull -> 327
    //   306: aload_0
    //   307: getfield mutatedKeys : Lcom/google/firebase/database/collection/ImmutableSortedSet;
    //   310: aload #12
    //   312: invokevirtual getKey : ()Lcom/google/firebase/firestore/model/DocumentKey;
    //   315: invokevirtual contains : (Ljava/lang/Object;)Z
    //   318: ifeq -> 327
    //   321: iconst_1
    //   322: istore #15
    //   324: goto -> 330
    //   327: iconst_0
    //   328: istore #15
    //   330: aload #13
    //   332: ifnull -> 372
    //   335: aload #13
    //   337: invokevirtual hasLocalMutations : ()Z
    //   340: ifne -> 366
    //   343: aload_0
    //   344: getfield mutatedKeys : Lcom/google/firebase/database/collection/ImmutableSortedSet;
    //   347: aload #13
    //   349: invokevirtual getKey : ()Lcom/google/firebase/firestore/model/DocumentKey;
    //   352: invokevirtual contains : (Ljava/lang/Object;)Z
    //   355: ifeq -> 372
    //   358: aload #13
    //   360: invokevirtual hasCommittedMutations : ()Z
    //   363: ifeq -> 372
    //   366: iconst_1
    //   367: istore #16
    //   369: goto -> 375
    //   372: iconst_0
    //   373: istore #16
    //   375: aload #12
    //   377: ifnull -> 513
    //   380: aload #13
    //   382: ifnull -> 513
    //   385: aload #12
    //   387: invokevirtual getData : ()Lcom/google/firebase/firestore/model/value/ObjectValue;
    //   390: aload #13
    //   392: invokevirtual getData : ()Lcom/google/firebase/firestore/model/value/ObjectValue;
    //   395: invokevirtual equals : (Ljava/lang/Object;)Z
    //   398: ifne -> 482
    //   401: aload_0
    //   402: aload #12
    //   404: aload #13
    //   406: invokespecial shouldWaitForSyncedDocument : (Lcom/google/firebase/firestore/model/Document;Lcom/google/firebase/firestore/model/Document;)Z
    //   409: ifne -> 507
    //   412: aload_3
    //   413: getstatic com/google/firebase/firestore/core/DocumentViewChange$Type.MODIFIED : Lcom/google/firebase/firestore/core/DocumentViewChange$Type;
    //   416: aload #13
    //   418: invokestatic create : (Lcom/google/firebase/firestore/core/DocumentViewChange$Type;Lcom/google/firebase/firestore/model/Document;)Lcom/google/firebase/firestore/core/DocumentViewChange;
    //   421: invokevirtual addChange : (Lcom/google/firebase/firestore/core/DocumentViewChange;)V
    //   424: aload #6
    //   426: ifnull -> 448
    //   429: aload_0
    //   430: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   433: invokevirtual comparator : ()Ljava/util/Comparator;
    //   436: aload #13
    //   438: aload #6
    //   440: invokeinterface compare : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   445: ifgt -> 472
    //   448: aload #7
    //   450: ifnull -> 501
    //   453: aload_0
    //   454: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   457: invokevirtual comparator : ()Ljava/util/Comparator;
    //   460: aload #13
    //   462: aload #7
    //   464: invokeinterface compare : (Ljava/lang/Object;Ljava/lang/Object;)I
    //   469: ifge -> 501
    //   472: iconst_1
    //   473: istore #17
    //   475: iload #17
    //   477: istore #9
    //   479: goto -> 510
    //   482: iload #15
    //   484: iload #16
    //   486: if_icmpeq -> 507
    //   489: aload_3
    //   490: getstatic com/google/firebase/firestore/core/DocumentViewChange$Type.METADATA : Lcom/google/firebase/firestore/core/DocumentViewChange$Type;
    //   493: aload #13
    //   495: invokestatic create : (Lcom/google/firebase/firestore/core/DocumentViewChange$Type;Lcom/google/firebase/firestore/model/Document;)Lcom/google/firebase/firestore/core/DocumentViewChange;
    //   498: invokevirtual addChange : (Lcom/google/firebase/firestore/core/DocumentViewChange;)V
    //   501: iconst_1
    //   502: istore #17
    //   504: goto -> 510
    //   507: iconst_0
    //   508: istore #17
    //   510: goto -> 591
    //   513: aload #12
    //   515: ifnonnull -> 542
    //   518: aload #13
    //   520: ifnull -> 542
    //   523: aload_3
    //   524: getstatic com/google/firebase/firestore/core/DocumentViewChange$Type.ADDED : Lcom/google/firebase/firestore/core/DocumentViewChange$Type;
    //   527: aload #13
    //   529: invokestatic create : (Lcom/google/firebase/firestore/core/DocumentViewChange$Type;Lcom/google/firebase/firestore/model/Document;)Lcom/google/firebase/firestore/core/DocumentViewChange;
    //   532: invokevirtual addChange : (Lcom/google/firebase/firestore/core/DocumentViewChange;)V
    //   535: iload #14
    //   537: istore #17
    //   539: goto -> 591
    //   542: aload #12
    //   544: ifnull -> 588
    //   547: aload #13
    //   549: ifnonnull -> 588
    //   552: aload_3
    //   553: getstatic com/google/firebase/firestore/core/DocumentViewChange$Type.REMOVED : Lcom/google/firebase/firestore/core/DocumentViewChange$Type;
    //   556: aload #12
    //   558: invokestatic create : (Lcom/google/firebase/firestore/core/DocumentViewChange$Type;Lcom/google/firebase/firestore/model/Document;)Lcom/google/firebase/firestore/core/DocumentViewChange;
    //   561: invokevirtual addChange : (Lcom/google/firebase/firestore/core/DocumentViewChange;)V
    //   564: aload #6
    //   566: ifnonnull -> 578
    //   569: iload #14
    //   571: istore #17
    //   573: aload #7
    //   575: ifnull -> 591
    //   578: iconst_1
    //   579: istore #9
    //   581: iload #14
    //   583: istore #17
    //   585: goto -> 591
    //   588: iconst_0
    //   589: istore #17
    //   591: aload #5
    //   593: astore #12
    //   595: aload_1
    //   596: astore #4
    //   598: iload #17
    //   600: ifeq -> 674
    //   603: aload #13
    //   605: ifnull -> 651
    //   608: aload #5
    //   610: aload #13
    //   612: invokevirtual add : (Lcom/google/firebase/firestore/model/Document;)Lcom/google/firebase/firestore/model/DocumentSet;
    //   615: astore #5
    //   617: aload #13
    //   619: invokevirtual hasLocalMutations : ()Z
    //   622: ifeq -> 638
    //   625: aload_1
    //   626: aload #13
    //   628: invokevirtual getKey : ()Lcom/google/firebase/firestore/model/DocumentKey;
    //   631: invokevirtual insert : (Ljava/lang/Object;)Lcom/google/firebase/database/collection/ImmutableSortedSet;
    //   634: astore_1
    //   635: goto -> 667
    //   638: aload_1
    //   639: aload #13
    //   641: invokevirtual getKey : ()Lcom/google/firebase/firestore/model/DocumentKey;
    //   644: invokevirtual remove : (Ljava/lang/Object;)Lcom/google/firebase/database/collection/ImmutableSortedSet;
    //   647: astore_1
    //   648: goto -> 667
    //   651: aload #5
    //   653: aload #11
    //   655: invokevirtual remove : (Lcom/google/firebase/firestore/model/DocumentKey;)Lcom/google/firebase/firestore/model/DocumentSet;
    //   658: astore #5
    //   660: aload_1
    //   661: aload #11
    //   663: invokevirtual remove : (Ljava/lang/Object;)Lcom/google/firebase/database/collection/ImmutableSortedSet;
    //   666: astore_1
    //   667: aload_1
    //   668: astore #4
    //   670: aload #5
    //   672: astore #12
    //   674: aload #12
    //   676: astore #5
    //   678: aload #4
    //   680: astore_1
    //   681: goto -> 158
    //   684: aload_0
    //   685: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   688: invokevirtual hasLimitToFirst : ()Z
    //   691: ifne -> 717
    //   694: aload #5
    //   696: astore #4
    //   698: aload_1
    //   699: astore #6
    //   701: aload_0
    //   702: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   705: invokevirtual hasLimitToLast : ()Z
    //   708: ifeq -> 714
    //   711: goto -> 717
    //   714: goto -> 844
    //   717: aload_0
    //   718: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   721: invokevirtual hasLimitToFirst : ()Z
    //   724: ifeq -> 739
    //   727: aload_0
    //   728: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   731: invokevirtual getLimitToFirst : ()J
    //   734: lstore #18
    //   736: goto -> 748
    //   739: aload_0
    //   740: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   743: invokevirtual getLimitToLast : ()J
    //   746: lstore #18
    //   748: aload #5
    //   750: invokevirtual size : ()I
    //   753: i2l
    //   754: lstore #20
    //   756: lload #20
    //   758: lload #18
    //   760: lsub
    //   761: lstore #20
    //   763: aload #5
    //   765: astore #4
    //   767: aload_1
    //   768: astore #6
    //   770: lload #20
    //   772: lconst_0
    //   773: lcmp
    //   774: ifle -> 714
    //   777: aload_0
    //   778: getfield query : Lcom/google/firebase/firestore/core/Query;
    //   781: invokevirtual hasLimitToFirst : ()Z
    //   784: ifeq -> 797
    //   787: aload #5
    //   789: invokevirtual getLastDocument : ()Lcom/google/firebase/firestore/model/Document;
    //   792: astore #4
    //   794: goto -> 804
    //   797: aload #5
    //   799: invokevirtual getFirstDocument : ()Lcom/google/firebase/firestore/model/Document;
    //   802: astore #4
    //   804: aload #5
    //   806: aload #4
    //   808: invokevirtual getKey : ()Lcom/google/firebase/firestore/model/DocumentKey;
    //   811: invokevirtual remove : (Lcom/google/firebase/firestore/model/DocumentKey;)Lcom/google/firebase/firestore/model/DocumentSet;
    //   814: astore #5
    //   816: aload_1
    //   817: aload #4
    //   819: invokevirtual getKey : ()Lcom/google/firebase/firestore/model/DocumentKey;
    //   822: invokevirtual remove : (Ljava/lang/Object;)Lcom/google/firebase/database/collection/ImmutableSortedSet;
    //   825: astore_1
    //   826: aload_3
    //   827: getstatic com/google/firebase/firestore/core/DocumentViewChange$Type.REMOVED : Lcom/google/firebase/firestore/core/DocumentViewChange$Type;
    //   830: aload #4
    //   832: invokestatic create : (Lcom/google/firebase/firestore/core/DocumentViewChange$Type;Lcom/google/firebase/firestore/model/Document;)Lcom/google/firebase/firestore/core/DocumentViewChange;
    //   835: invokevirtual addChange : (Lcom/google/firebase/firestore/core/DocumentViewChange;)V
    //   838: lconst_1
    //   839: lstore #18
    //   841: goto -> 756
    //   844: iload #9
    //   846: ifeq -> 862
    //   849: aload_2
    //   850: ifnonnull -> 856
    //   853: goto -> 862
    //   856: iconst_0
    //   857: istore #17
    //   859: goto -> 865
    //   862: iconst_1
    //   863: istore #17
    //   865: iload #17
    //   867: ldc_w 'View was refilled using docs that themselves needed refilling.'
    //   870: iconst_0
    //   871: anewarray java/lang/Object
    //   874: invokestatic hardAssert : (ZLjava/lang/String;[Ljava/lang/Object;)V
    //   877: new com/google/firebase/firestore/core/View$DocumentChanges
    //   880: dup
    //   881: aload #4
    //   883: aload_3
    //   884: aload #6
    //   886: iload #9
    //   888: aconst_null
    //   889: invokespecial <init> : (Lcom/google/firebase/firestore/model/DocumentSet;Lcom/google/firebase/firestore/core/DocumentViewChangeSet;Lcom/google/firebase/database/collection/ImmutableSortedSet;ZLcom/google/firebase/firestore/core/View$1;)V
    //   892: areturn
  }
  
  ImmutableSortedSet<DocumentKey> getLimboDocuments() {
    return this.limboDocuments;
  }
  
  public ViewSnapshot.SyncState getSyncState() {
    return this.syncState;
  }
  
  ImmutableSortedSet<DocumentKey> getSyncedDocuments() {
    return this.syncedDocuments;
  }
  
  public static class DocumentChanges {
    final DocumentViewChangeSet changeSet;
    
    final DocumentSet documentSet;
    
    final ImmutableSortedSet<DocumentKey> mutatedKeys;
    
    private final boolean needsRefill;
    
    private DocumentChanges(DocumentSet param1DocumentSet, DocumentViewChangeSet param1DocumentViewChangeSet, ImmutableSortedSet<DocumentKey> param1ImmutableSortedSet, boolean param1Boolean) {
      this.documentSet = param1DocumentSet;
      this.changeSet = param1DocumentViewChangeSet;
      this.mutatedKeys = param1ImmutableSortedSet;
      this.needsRefill = param1Boolean;
    }
    
    public boolean needsRefill() {
      return this.needsRefill;
    }
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\core\View.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */