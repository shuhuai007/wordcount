package com.zhoujie.hive.mapreduce.output;

import com.zhoujie.hive.FactPBHive.ShangHai;
import com.twitter.elephantbird.mapreduce.output.LzoProtobufB64LineOutputFormat;
import com.twitter.elephantbird.util.TypeRef;

public class LzoShangHaiProtobufB64LineOutputFormat extends LzoProtobufB64LineOutputFormat<ShangHai> {
  public LzoShangHaiProtobufB64LineOutputFormat() {
    super(new TypeRef<ShangHai>(){});
  }
}

