USE ifc;

drop table shanghai; 
create table shanghai (region_name STRING, info STRING)
  row format serde "com.zhoujie.hive.hive.serde.LzoShangHaiProtobufHiveSerde"
  stored as
    inputformat "com.zhoujie.hive.mapreduce.input.LzoShangHaiProtobufB64LineInputFormat"
    outputformat  "org.apache.hadoop.hive.ql.io.HiveNullValueSequenceFileOutputFormat";

LOAD DATA INPATH '/user/hadoop/zhoujie/output/multioutput_pb/shanghai/' INTO TABLE shanghai;

