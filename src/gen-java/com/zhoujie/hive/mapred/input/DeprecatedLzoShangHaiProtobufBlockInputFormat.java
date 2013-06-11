package com.zhoujie.hive.mapred.input;

import com.zhoujie.hive.FactPBHive.ShangHai;
import com.twitter.elephantbird.mapred.input.DeprecatedLzoProtobufBlockInputFormat;
import com.zhoujie.hive.mapreduce.io.ProtobufShangHaiWritable;
import com.twitter.elephantbird.util.TypeRef;

public class DeprecatedLzoShangHaiProtobufBlockInputFormat extends DeprecatedLzoProtobufBlockInputFormat<ShangHai, ProtobufShangHaiWritable> {
  public DeprecatedLzoShangHaiProtobufBlockInputFormat() {
    setTypeRef(new TypeRef<ShangHai>(){});
    setProtobufWritable(new ProtobufShangHaiWritable());
  }
}

