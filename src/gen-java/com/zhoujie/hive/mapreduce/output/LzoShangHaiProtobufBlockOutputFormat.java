package com.zhoujie.hive.mapreduce.output;

import com.zhoujie.hive.FactPBHive.ShangHai;
import com.twitter.elephantbird.mapreduce.output.LzoProtobufBlockOutputFormat;
import com.twitter.elephantbird.util.TypeRef;

public class LzoShangHaiProtobufBlockOutputFormat extends LzoProtobufBlockOutputFormat<ShangHai> {
  public LzoShangHaiProtobufBlockOutputFormat() {
    super(new TypeRef<ShangHai>(){});
  }
}

