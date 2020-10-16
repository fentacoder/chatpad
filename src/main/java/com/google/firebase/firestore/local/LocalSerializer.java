package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.UnknownDocument;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.firebase.firestore.proto.NoDocument;
import com.google.firebase.firestore.proto.Target;
import com.google.firebase.firestore.proto.UnknownDocument;
import com.google.firebase.firestore.proto.WriteBatch;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Document;
import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Map;

public final class LocalSerializer {
  private final RemoteSerializer rpcSerializer;
  
  public LocalSerializer(RemoteSerializer paramRemoteSerializer) {
    this.rpcSerializer = paramRemoteSerializer;
  }
  
  private Document decodeDocument(Document paramDocument, boolean paramBoolean) {
    Document.DocumentState documentState;
    DocumentKey documentKey = this.rpcSerializer.decodeKey(paramDocument.getName());
    SnapshotVersion snapshotVersion = this.rpcSerializer.decodeVersion(paramDocument.getUpdateTime());
    if (paramBoolean) {
      documentState = Document.DocumentState.COMMITTED_MUTATIONS;
    } else {
      documentState = Document.DocumentState.SYNCED;
    } 
    RemoteSerializer remoteSerializer = this.rpcSerializer;
    remoteSerializer.getClass();
    return new Document(documentKey, snapshotVersion, documentState, paramDocument, LocalSerializer$$Lambda$1.lambdaFactory$(remoteSerializer));
  }
  
  private NoDocument decodeNoDocument(NoDocument paramNoDocument, boolean paramBoolean) {
    return new NoDocument(this.rpcSerializer.decodeKey(paramNoDocument.getName()), this.rpcSerializer.decodeVersion(paramNoDocument.getReadTime()), paramBoolean);
  }
  
  private UnknownDocument decodeUnknownDocument(UnknownDocument paramUnknownDocument) {
    return new UnknownDocument(this.rpcSerializer.decodeKey(paramUnknownDocument.getName()), this.rpcSerializer.decodeVersion(paramUnknownDocument.getVersion()));
  }
  
  private Document encodeDocument(Document paramDocument) {
    Document.Builder builder = Document.newBuilder();
    builder.setName(this.rpcSerializer.encodeKey(paramDocument.getKey()));
    for (Map.Entry entry : paramDocument.getData().getInternalValue())
      builder.putFields((String)entry.getKey(), this.rpcSerializer.encodeValue((FieldValue)entry.getValue())); 
    Timestamp timestamp = paramDocument.getVersion().getTimestamp();
    builder.setUpdateTime(this.rpcSerializer.encodeTimestamp(timestamp));
    return (Document)builder.build();
  }
  
  private NoDocument encodeNoDocument(NoDocument paramNoDocument) {
    NoDocument.Builder builder = NoDocument.newBuilder();
    builder.setName(this.rpcSerializer.encodeKey(paramNoDocument.getKey()));
    builder.setReadTime(this.rpcSerializer.encodeTimestamp(paramNoDocument.getVersion().getTimestamp()));
    return (NoDocument)builder.build();
  }
  
  private UnknownDocument encodeUnknownDocument(UnknownDocument paramUnknownDocument) {
    UnknownDocument.Builder builder = UnknownDocument.newBuilder();
    builder.setName(this.rpcSerializer.encodeKey(paramUnknownDocument.getKey()));
    builder.setVersion(this.rpcSerializer.encodeTimestamp(paramUnknownDocument.getVersion().getTimestamp()));
    return (UnknownDocument)builder.build();
  }
  
  MaybeDocument decodeMaybeDocument(MaybeDocument paramMaybeDocument) {
    int i = null.$SwitchMap$com$google$firebase$firestore$proto$MaybeDocument$DocumentTypeCase[paramMaybeDocument.getDocumentTypeCase().ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i == 3)
          return (MaybeDocument)decodeUnknownDocument(paramMaybeDocument.getUnknownDocument()); 
        throw Assert.fail("Unknown MaybeDocument %s", new Object[] { paramMaybeDocument });
      } 
      return (MaybeDocument)decodeNoDocument(paramMaybeDocument.getNoDocument(), paramMaybeDocument.getHasCommittedMutations());
    } 
    return (MaybeDocument)decodeDocument(paramMaybeDocument.getDocument(), paramMaybeDocument.getHasCommittedMutations());
  }
  
  MutationBatch decodeMutationBatch(WriteBatch paramWriteBatch) {
    int i = paramWriteBatch.getBatchId();
    Timestamp timestamp = this.rpcSerializer.decodeTimestamp(paramWriteBatch.getLocalWriteTime());
    int j = paramWriteBatch.getBaseWritesCount();
    ArrayList<Mutation> arrayList1 = new ArrayList(j);
    boolean bool = false;
    byte b;
    for (b = 0; b < j; b++)
      arrayList1.add(this.rpcSerializer.decodeMutation(paramWriteBatch.getBaseWrites(b))); 
    j = paramWriteBatch.getWritesCount();
    ArrayList<Mutation> arrayList2 = new ArrayList(j);
    for (b = bool; b < j; b++)
      arrayList2.add(this.rpcSerializer.decodeMutation(paramWriteBatch.getWrites(b))); 
    return new MutationBatch(i, timestamp, arrayList1, arrayList2);
  }
  
  QueryData decodeQueryData(Target paramTarget) {
    Target target;
    int i = paramTarget.getTargetId();
    SnapshotVersion snapshotVersion1 = this.rpcSerializer.decodeVersion(paramTarget.getSnapshotVersion());
    SnapshotVersion snapshotVersion2 = this.rpcSerializer.decodeVersion(paramTarget.getLastLimboFreeSnapshotVersion());
    ByteString byteString = paramTarget.getResumeToken();
    long l = paramTarget.getLastListenSequenceNumber();
    int j = null.$SwitchMap$com$google$firebase$firestore$proto$Target$TargetTypeCase[paramTarget.getTargetTypeCase().ordinal()];
    if (j != 1) {
      if (j == 2) {
        target = this.rpcSerializer.decodeQueryTarget(paramTarget.getQuery());
      } else {
        throw Assert.fail("Unknown targetType %d", new Object[] { target.getTargetTypeCase() });
      } 
    } else {
      target = this.rpcSerializer.decodeDocumentsTarget(target.getDocuments());
    } 
    return new QueryData(target, i, l, QueryPurpose.LISTEN, snapshotVersion1, snapshotVersion2, byteString);
  }
  
  MaybeDocument encodeMaybeDocument(MaybeDocument paramMaybeDocument) {
    NoDocument noDocument;
    MaybeDocument.Builder builder = MaybeDocument.newBuilder();
    if (paramMaybeDocument instanceof NoDocument) {
      noDocument = (NoDocument)paramMaybeDocument;
      builder.setNoDocument(encodeNoDocument(noDocument));
      builder.setHasCommittedMutations(noDocument.hasCommittedMutations());
    } else {
      Document document;
      if (noDocument instanceof Document) {
        document = (Document)noDocument;
        if (document.getProto() != null) {
          builder.setDocument(document.getProto());
        } else {
          builder.setDocument(encodeDocument(document));
        } 
        builder.setHasCommittedMutations(document.hasCommittedMutations());
      } else {
        if (document instanceof UnknownDocument) {
          builder.setUnknownDocument(encodeUnknownDocument((UnknownDocument)document));
          builder.setHasCommittedMutations(true);
          return (MaybeDocument)builder.build();
        } 
        throw Assert.fail("Unknown document type %s", new Object[] { document.getClass().getCanonicalName() });
      } 
    } 
    return (MaybeDocument)builder.build();
  }
  
  WriteBatch encodeMutationBatch(MutationBatch paramMutationBatch) {
    WriteBatch.Builder builder = WriteBatch.newBuilder();
    builder.setBatchId(paramMutationBatch.getBatchId());
    builder.setLocalWriteTime(this.rpcSerializer.encodeTimestamp(paramMutationBatch.getLocalWriteTime()));
    for (Mutation mutation : paramMutationBatch.getBaseMutations())
      builder.addBaseWrites(this.rpcSerializer.encodeMutation(mutation)); 
    for (Mutation mutation : paramMutationBatch.getMutations())
      builder.addWrites(this.rpcSerializer.encodeMutation(mutation)); 
    return (WriteBatch)builder.build();
  }
  
  Target encodeQueryData(QueryData paramQueryData) {
    Assert.hardAssert(QueryPurpose.LISTEN.equals(paramQueryData.getPurpose()), "Only queries with purpose %s may be stored, got %s", new Object[] { QueryPurpose.LISTEN, paramQueryData.getPurpose() });
    Target.Builder builder = Target.newBuilder();
    builder.setTargetId(paramQueryData.getTargetId()).setLastListenSequenceNumber(paramQueryData.getSequenceNumber()).setLastLimboFreeSnapshotVersion(this.rpcSerializer.encodeVersion(paramQueryData.getLastLimboFreeSnapshotVersion())).setSnapshotVersion(this.rpcSerializer.encodeVersion(paramQueryData.getSnapshotVersion())).setResumeToken(paramQueryData.getResumeToken());
    Target target = paramQueryData.getTarget();
    if (target.isDocumentQuery()) {
      builder.setDocuments(this.rpcSerializer.encodeDocumentsTarget(target));
    } else {
      builder.setQuery(this.rpcSerializer.encodeQueryTarget(target));
    } 
    return (Target)builder.build();
  }
}


/* Location:              C:\Users\jamar\Documents\android_location\apk_conversion\dex2jar-3.0\classes2-dex2jar.jar!\com\google\firebase\firestore\local\LocalSerializer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */