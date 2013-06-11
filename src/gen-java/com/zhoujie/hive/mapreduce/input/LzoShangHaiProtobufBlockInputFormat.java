package com.zhoujie.hive.mapreduce.input;

import com.zhoujie.hive.FactPBHive.ShangHai;
import com.twitter.elephantbird.mapreduce.input.LzoProtobufBlockInputFormat;
import com.twitter.elephantbird.util.TypeRef;

public class LzoShangHaiProtobufBlockInputFormat extends LzoProtobufBlockInputFormat<ShangHai> {
  public LzoShangHaiProtobufBlockInputFormat() {
    super(new TypeRef<ShangHai>(){});
  }
}

