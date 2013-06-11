create table shanghai (region_name STRING, info STRING)
  row format serde "com.zhoujie.hive.hive.serde.LzoShangHaiProtobufHiveSerde"
  with serdeproperties (
    "serialization.class"="com.zhoujie.hive.FactPBHive$ShangHai")
  stored as
    inputformat "com.zhoujie.hive.mapreduce.input.LzoShangHaiProtobufBlockInputFormat";