package com.zhoujie.hive.mapreduce.io;

import com.zhoujie.hive.FactPBHive.ShangHai;
import com.twitter.elephantbird.mapreduce.io.ProtobufWritable;
import com.twitter.elephantbird.util.TypeRef;

public class ProtobufShangHaiWritable extends ProtobufWritable<ShangHai> {
  public ProtobufShangHaiWritable() {
    super(new TypeRef<ShangHai>(){});
  }
  public ProtobufShangHaiWritable(ShangHai m) {
    super(m, new TypeRef<ShangHai>(){});
  }
}

