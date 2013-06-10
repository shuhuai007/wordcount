package com.zhoujie.test;

import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.PathFilter;

public class InputFilter implements PathFilter, Configurable {
    
    @Override
    public Configuration getConf() {
        // TODO Auto-generated method stub
        return this.getConf();
    }

    @Override
    public void setConf(Configuration arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean accept(Path arg0) {
        // TODO Auto-generated method stub
        return false;
    }

}
