package com.zhoujie.test;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public abstract class AbstractMutilOutputMapper<VALUEIN, VALUEOUT> extends
        Mapper<LongWritable, VALUEIN, NullWritable, VALUEOUT> {

    protected String uniquePrefix_;
    protected MultipleOutputs<NullWritable, VALUEOUT> mos_;

    @Override
    protected void setup(Context context) throws IOException,
            InterruptedException {
        mos_ = new MultipleOutputs<NullWritable, VALUEOUT>(context);
        uniquePrefix_ = getOutputFileUniquePrefix(context);
    }

    @Override
    protected void cleanup(Context context) throws IOException,
            InterruptedException {
        mos_.close();
    }

    protected abstract String getBaseOutputPath(String dirname);

    protected String getOutputFileUniquePrefix(Context context) {
        return context.getTaskAttemptID().toString();
    }
}
