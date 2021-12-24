package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.cli.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/6/28 14:23
 * @Description: TODO
 */
@RestController
@RequestMapping("/controller")
public class Controller {

    private Map<String, Integer> map = new HashMap<>();




    @RequestMapping("/test")
    public long test() {

        ThreadLocalTest.setVal("a");
        System.out.println(ThreadLocalTest.getVal());
        return 0;
        /*long count = java.lang.management.ManagementFactory.getClassLoadingMXBean().getTotalLoadedClassCount();
        long count1 = java.lang.management.ManagementFactory.getClassLoadingMXBean().getLoadedClassCount();
        long count2 = java.lang.management.ManagementFactory.getClassLoadingMXBean().getUnloadedClassCount();
        long count3 = java.lang.management.ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
        long count4 = java.lang.management.ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax();
        System.out.println(count + "--" + count1 + "--" + count2 + "--" + count3 + "--" + count4);
        String processName = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
        if (processName != null && processName.length() > 0) {
            try {
                return Long.parseLong(processName.split("@")[0]);
            } catch (Exception e) {
                return 0;
            }
        }

        return 0;
*/

    }

    @RequestMapping("/test1")
    public String test1() throws IOException {

      /*  String path = System.getProperty("user.dir");
        InputStream inputStream = new FileInputStream(new File(path + "\\src\\main\\resources\\application.properties"));
        Properties properties = new Properties();
        properties.load(inputStream);
        properties.put("test3", "t");
        System.out.println(properties.get("test3"));
        String result = (String) properties.get("spring.redis.timeout");*/
        System.out.println(ThreadLocalTest.getVal());
        return "success";


    }


  /*  public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            Options options = new Options();
            options.addOption("M", true, "main app classname");
            options.addOption("P", true, "properties filename");
            OptionBuilder.withArgName("property=value");
            OptionBuilder.hasArgs(2);
            OptionBuilder.withValueSeparator();
            OptionBuilder.withDescription("use value for given property");
            options.addOption(OptionBuilder.create("D"));
            CommandLineParser parser = new PosixParser();
            CommandLine cmd = null;
            try {
                cmd = parser.parse(options, args);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (cmd.hasOption('M')) {
                String fullClassName = cmd.getOptionValue('M');
                if (fullClassName != null && !fullClassName.isEmpty()) {
                    if (cmd.hasOption('P')) {
                        File file = new File(cmd.getOptionValue('P'));
                        try {
                            FileInputStream fStream = new FileInputStream(file);
                            try {
                                properties.load(fStream);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                    }
                    properties.putAll(cmd.getOptionProperties("D"));
                    properties.setProperty("conf.app.startup.timestamp", String.valueOf((new Date()).getTime())); //当前时间戳加入到配置中
                    System.out.println("properties:" + properties.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
  public static void main(String[] args) {


  }


}
