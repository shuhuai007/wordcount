package com.zhoujie.hive.mapreduce.input;

import com.zhoujie.hive.FactPBHive.ShangHai;
import com.twitter.elephantbird.mapreduce.input.LzoProtobufB64LineInputFormat;
import com.twitter.elephantbird.util.TypeRef;

public class LzoShangHaiProtobufB64LineInputFormat extends LzoProtobufB64LineInputFormat<ShangHai> {
  public LzoShangHaiProtobufB64LineInputFormat() {
    super(new TypeRef<ShangHai>(){});
  }
}

