package com.zhoujie.hive.hive.serde;

import com.zhoujie.hive.FactPBHive.ShangHai;
import com.zhoujie.hive.mapreduce.io.ProtobufShangHaiWritable;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory.ObjectInspectorOptions;
import org.apache.hadoop.io.Writable;
import com.twitter.elephantbird.hive.serde.LzoProtobufHiveSerde;

public class LzoShangHaiProtobufHiveSerde extends LzoProtobufHiveSerde {
  public ObjectInspector getObjectInspector() throws SerDeException {
    return ObjectInspectorFactory.getReflectionObjectInspector(ShangHai.class, ObjectInspectorOptions.PROTOCOL_BUFFERS);
  }

  public Object deserialize(Writable w) throws SerDeException {
    return ((ProtobufShangHaiWritable) w).get();
  }
}

