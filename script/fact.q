USE ifc;

drop table shanghai; 
create table shanghai (region_name STRING, info STRING)
  row format serde "com.zhoujie.hive.hive.serde.LzoShangHaiProtobufHiveSerde"
  with serdeproperties (
    "serialization.class"="com.zhoujie.hive.FactPBHive$ShangHai")
  stored as
    inputformat "com.zhoujie.hive.mapreduce.input.LzoShangHaiProtobufBlockInputFormat"
    outputformat  "org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat";

LOAD DATA INPATH '/user/hadoop/zhoujie/output/multioutput_pb/shanghai/' INTO TABLE shanghai;

