package com.zql.crawler;

import com.zql.dataobject.WechatArticle;
import com.zql.dto.ArticleInfoDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * Created by 张启磊 on 2019-3-12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleDetailCrawlerTest {
    @Autowired
    private  ArticleDetailCrawler crawler;
    @Test
    public void getDetail() throws Exception {
        ArticleInfoDto dto = new ArticleInfoDto();
        WechatArticle article = new WechatArticle();
        article.setArticleContentUrl("https://mp.weixin.qq.com/s?timestamp=1552308999&src=3&ver=1&signature=0DSLlcFDaILJPWItrJEx9n91Z9cqJRFFe1B4GwlueH3VwHuI8F8zWPjGn94MTcLPRR51YZYrnjMd4EbtSOmY*yrmgJWDlh0wmAXg4fMOcEOmJBQgwwb256FVhFOtQviyvkpFM3i932PrGSdcaIpXferBATkleUisqBFRpgwCAyw=");
        article.setArticleId(346);
        ArrayList list = new ArrayList();
        list.add(article);
        dto.setArticles(list);
        crawler.getDetail(dto);
    }

    @Test
    public  void  parse(){
        Document doc = Jsoup.parse("<div class=\"rich_media_content \" id=\"js_content\"> \n" +
                "        <section class=\"xmteditor\" style=\"display:none;\" data-tools=\"新媒体管家\" data-label=\"powered by xmt.cn\" data-mpa-powered-by=\"yiban.io\"></section>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">当提起这三个词的时候，是不是很多人都认为分布式=高并发=多线程？</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><br></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">当面试官问到高并发系统可以采用哪些手段来解决，或者被问到分布式系统如何解决一致性的问题，是不是一脸懵逼？</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">&nbsp;</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">确实，在一开始接触的时候，不少人都会将三者混淆，误以为所谓的分布式高并发的系统就是能同时供海量用户访问，而采用多线程手段不就是可以提供系统的并发能力吗？实际上，<strong>他们三个总是相伴而生，但侧重点又有不同。</strong></span></p>\n" +
                "        <section style=\"color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);\">\n" +
                "         <section class=\"\" powered-by=\"xiumi.us\" style=\"text-align: center;\">\n" +
                "          <p style=\"margin-top: 20px;margin-bottom: 10px;font-family: Optima-Regular, PingFangTC-light;\"><br></p>\n" +
                "          <section style=\"padding-right: 8px;padding-bottom: 8px;padding-left: 8px;display: inline-block;min-width: 10%;vertical-align: top;background-color: rgb(245, 213, 66);\">\n" +
                "           <section class=\"\" powered-by=\"xiumi.us\">\n" +
                "            <section style=\"margin-top: -10px;\">\n" +
                "             <section style=\"padding: 3px;display: inline-block;border-bottom: 1px solid rgb(62, 62, 62);line-height: 1;letter-spacing: 0.8px;\">\n" +
                "              <p><em><strong><span style=\"font-size: 15px;text-align: justify;\">什么是分布式？</span></strong></em></p>\n" +
                "             </section>\n" +
                "            </section>\n" +
                "           </section>\n" +
                "          </section>\n" +
                "          <p><br></p>\n" +
                "         </section>\n" +
                "        </section>\n" +
                "        <p style=\"color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><br></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">分布式更多的一个概念，<strong>是为了解决单个物理服务器容量和性能瓶颈问题而采用的优化手段</strong>。该领域需要解决的问题极多，在不同的技术层面上，又包括：分布式文件系统、分布式缓存、分布式数据库、分布式计算等，一些名词如Hadoop、zookeeper、MQ等都跟分布式有关。从理念上讲，分布式的实现有两种形式：</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">&nbsp;</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><strong><span style=\"font-size: 15px;\">水平扩展：</span></strong><span style=\"font-size: 15px;\">当一台机器扛不住流量时，就通过添加机器的方式，将流量平分到所有服务器上，所有机器都可以提供相当的服务；</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">&nbsp;</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><strong><span style=\"font-size: 15px;\">垂直拆分：</span></strong><span style=\"font-size: 15px;\">前端有多种查询需求时，一台机器扛不住，可以将不同的需求分发到不同的机器上，比如A机器处理余票查询的请求，B机器处理支付的请求。</span></p>\n" +
                "        <p style=\"color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><br></p>\n" +
                "        <p style=\"color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><br></p>\n" +
                "        <section style=\"color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);\">\n" +
                "         <section class=\"\" powered-by=\"xiumi.us\" style=\"text-align: center;\">\n" +
                "          <section style=\"padding-right: 8px;padding-bottom: 8px;padding-left: 8px;display: inline-block;min-width: 10%;vertical-align: top;background-color: rgb(245, 213, 66);\">\n" +
                "           <section class=\"\" powered-by=\"xiumi.us\">\n" +
                "            <section style=\"margin-top: -10px;\">\n" +
                "             <section style=\"padding: 3px;display: inline-block;border-bottom: 1px solid rgb(62, 62, 62);line-height: 1;letter-spacing: 0.8px;\">\n" +
                "              <p><em><strong><span style=\"font-size: 15px;text-align: justify;\">什么是高并发？</span></strong></em></p>\n" +
                "             </section>\n" +
                "            </section>\n" +
                "           </section>\n" +
                "          </section>\n" +
                "          <p><br></p>\n" +
                "         </section>\n" +
                "        </section>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><strong><span style=\"font-size: 15px;\">相对于分布式来讲，高并发在解决的问题上会集中一些，其反应的是同时有多少量</span></strong><span style=\"font-size: 15px;\">：比如在线直播服务，同时有上万人观看。</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><br></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">高并发可以通过分布式技术去解决，将并发流量分到不同的物理服务器上。但除此之外，还可以有很多其他优化手段：比如使用缓存系统，将所有的，静态内容放到CDN等；还可以使用多线程技术将一台服务器的服务能力最大化。</span></p>\n" +
                "        <section style=\"color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);\">\n" +
                "         <section class=\"\" powered-by=\"xiumi.us\" style=\"text-align: center;\">\n" +
                "          <p style=\"text-align: center;\"><img class=\"\" data-copyright=\"0\" data-ratio=\"0.5149006622516556\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"1208\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/4MXV7svuTWIaq3k3iaB0iaE4QDicOfhm46DulNKNeQicv4BEDpl2RdFgpaNy38adYcDuNTo5tgP98HFmwibiaP6ibkcvQ/640?wx_fmt=jpeg\" style=\"\"></p>\n" +
                "          <p style=\"text-align: center;\"><br></p>\n" +
                "          <p style=\"text-align: center;\"><br></p>\n" +
                "          <section style=\"padding-right: 8px;padding-bottom: 8px;padding-left: 8px;display: inline-block;min-width: 10%;vertical-align: top;background-color: rgb(245, 213, 66);\">\n" +
                "           <section class=\"\" powered-by=\"xiumi.us\">\n" +
                "            <section style=\"margin-top: -10px;\">\n" +
                "             <section style=\"padding: 3px;display: inline-block;border-bottom: 1px solid rgb(62, 62, 62);line-height: 1;letter-spacing: 0.8px;\">\n" +
                "              <p><em><strong><span style=\"font-size: 15px;text-align: justify;\">什么是多线程？</span></strong></em></p>\n" +
                "             </section>\n" +
                "            </section>\n" +
                "           </section>\n" +
                "          </section>\n" +
                "          <p><br></p>\n" +
                "         </section>\n" +
                "        </section>\n" +
                "        <p style=\"color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><br></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><strong><span style=\"font-size: 15px;\">多线程是指从软件或者硬件上实现多个线程并发执行的技术</span></strong><span style=\"font-size: 15px;\">，它更多的是解决CPU调度多个进程的问题，从而让这些进程看上去是同时执行（实际是交替运行的）。</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><br></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">这几个概念中，<strong>多线程解决的问题是最明确的，手段也是比较单一的，基本上遇到的最大问题就是线程安全</strong>。在JAVA语言中，需要对JVM内存模型、指令重排等深入了解，才能写出一份高质量的多线程代码。</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">&nbsp;</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><strong><span style=\"font-size: 15px;\">总结一下：</span></strong></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><strong><span style=\"font-size: 15px;\">&nbsp;</span></strong></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">●</span><span style=\"font-size: 15px;color: rgb(0, 0, 0);\">分布式是从物理资源的角度去将不同的机器组成一个整体对外服务，技术范围非常广且难度非常大，有了这个基础，高并发、高吞吐等系统很容易构建；</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><br></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;color: rgb(0, 0, 0);\">● 高并发是从业务角度去描述系统的能力，实现高并发的手段可以采用分布式，也可以采用诸如缓存、CDN等，当然也包括多线程；</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;color: rgb(0, 0, 0);\">&nbsp;</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;color: rgb(0, 0, 0);\">● 多线程则聚焦于如何使用编程语言将CPU调度能力最大化。</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;\">&nbsp;</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><span style=\"font-size: 15px;color: rgb(0, 0, 0);\">分布式与高并发系统，涉及到大量的概念和知识点，如果没有系统的学习，很容易会杂糅概念而辨识不清，在面试与实际工作中都会遇到困难。如果你从事Java开发，<strong>具备1年以上工作经验，希望深入浅出了解Java分布式、高并发等技术要点</strong>，渴望实现技术和职业成长上的双重突破，那么以下福利就很适合你：</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;color: rgb(51, 51, 51);font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;letter-spacing: 0.5px;font-family: Optima-Regular, PingFangTC-light;background-color: rgb(255, 255, 255);\"><br></p>\n" +
                "        <section style=\"padding-right: 0.5em;padding-left: 0.5em;font-variant-numeric: normal;font-variant-east-asian: normal;white-space: normal;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;letter-spacing: 0.544px;text-align: justify;background-color: rgb(255, 255, 255);widows: 1;line-height: 25.6px;overflow-wrap: break-word !important;\">\n" +
                "         <section class=\"\" powered-by=\"xiumi.us\" style=\"text-align: center;overflow-wrap: break-word !important;\">\n" +
                "          <section style=\"letter-spacing: 0.544px;display: inline-block;min-width: 10%;vertical-align: top;background-color: rgb(255, 202, 0);overflow-wrap: break-word !important;\">\n" +
                "           <section class=\"\" powered-by=\"xiumi.us\" style=\"overflow-wrap: break-word !important;\">\n" +
                "            <section style=\"margin-top: 5px;margin-bottom: -5px;transform: translate3d(5px, 0px, 0px);overflow-wrap: break-word !important;\">\n" +
                "             <section style=\"padding-right: 8px;padding-left: 8px;display: inline-block;min-width: 10%;vertical-align: top;border-style: solid;border-width: 8px 1px 1px;border-radius: 0px;border-color: rgb(62, 62, 62);background-color: rgb(255, 255, 255);overflow-wrap: break-word !important;\">\n" +
                "              <section class=\"\" powered-by=\"xiumi.us\" style=\"overflow-wrap: break-word !important;\">\n" +
                "               <section style=\"overflow-wrap: break-word !important;\">\n" +
                "                <section style=\"padding-right: 8px;padding-left: 8px;text-align: left;overflow-wrap: break-word !important;\">\n" +
                "                 <p style=\"overflow-wrap: break-word !important;\"><strong style=\"overflow-wrap: break-word !important;\"><em style=\"overflow-wrap: break-word !important;\"><strong style=\"letter-spacing: 0.544px;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;overflow-wrap: break-word !important;\"><em style=\"overflow-wrap: break-word !important;\"><strong style=\"overflow-wrap: break-word !important;\">福利1&nbsp; 免费直播课程</strong></em></span></strong></em></strong></p>\n" +
                "                </section>\n" +
                "               </section>\n" +
                "              </section>\n" +
                "             </section>\n" +
                "            </section>\n" +
                "           </section>\n" +
                "          </section>\n" +
                "         </section>\n" +
                "        </section>\n" +
                "        <p style=\"margin-right: 8px;margin-left: 8px;padding-right: 0.5em;padding-left: 0.5em;font-variant-numeric: normal;font-variant-east-asian: normal;white-space: normal;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;background-color: rgb(255, 255, 255);widows: 1;text-align: center;letter-spacing: 1.5px;line-height: 1.75em;overflow-wrap: break-word !important;\"><br style=\"overflow-wrap: break-word !important;\"></p>\n" +
                "        <p style=\"white-space: normal;color: rgb(51, 51, 51);font-size: 17px;letter-spacing: 0.544px;background-color: rgb(255, 255, 255);widows: 1;text-align: center;line-height: 1.75em;font-family: Arial, Helvetica, sans-serif;overflow-wrap: break-word !important;\"><strong style=\"color: rgb(62, 62, 62);font-size: 15px;text-indent: 0em;letter-spacing: 1.5px;overflow-wrap: break-word !important;\">《</strong><strong style=\"letter-spacing: 1px;color: rgb(62, 62, 62);font-size: 15px;text-indent: 0em;overflow-wrap: break-word !important;\">网易云课堂Java进阶面试系列免费直播课<strong style=\"text-indent: 0em;letter-spacing: 1.5px;overflow-wrap: break-word !important;\">》</strong></strong></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;text-indent: 0em;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;text-align: center;letter-spacing: 1px;line-height: 1.75em;font-family: Arial, Helvetica, sans-serif;overflow-wrap: break-word !important;\"><span style=\"text-indent: 0em;font-size: 15px;color: rgb(62, 62, 62);overflow-wrap: break-word !important;\">适听人群：</span><span style=\"text-indent: 0em;color: rgb(62, 62, 62);font-size: 15px;\">Java初、中级开发工程师</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;text-indent: 0em;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;text-align: center;letter-spacing: 1px;line-height: 1.75em;font-family: Arial, Helvetica, sans-serif;overflow-wrap: break-word !important;\"><span style=\"text-indent: 0em;color: rgb(62, 62, 62);font-size: 15px;\"><br></span></p>\n" +
                "        <p style=\"white-space: normal;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;letter-spacing: 1.5px;text-align: center;\"><span style=\"color: rgb(129, 201, 86);\"><strong><span style=\"font-size: 15px;\">3.11-3.16&nbsp; 连续6天每晚8点准时直播</span></strong></span></p>\n" +
                "        <p style=\"white-space: normal;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;letter-spacing: 1.5px;text-align: center;\"><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">▼</span></p>\n" +
                "        <section style=\"white-space: normal;\">\n" +
                "         <section powered-by=\"xiumi.us\">\n" +
                "          <section>\n" +
                "           <section>\n" +
                "            <blockquote>\n" +
                "             <p style=\"margin-right: 8px;margin-left: 8px;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;letter-spacing: 1.5px;text-align: left;\"><strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">3月11日</span></strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">：面试季~听完次课，简历技能栏一定要加上消息中间件(MQ)&nbsp;</span></p>\n" +
                "             <p style=\"margin-right: 8px;margin-left: 8px;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;letter-spacing: 1.5px;text-align: left;\"><strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">3月12日</span></strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">：面试季~面试必问springboot知多少 - starter核心原理揭秘</span></p>\n" +
                "             <p style=\"margin-right: 8px;margin-left: 8px;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;letter-spacing: 1.5px;text-align: left;\"><strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">3月13日</span></strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">：面试季~教你生产环境日志分析的正确姿势</span></p>\n" +
                "             <p style=\"margin-right: 8px;margin-left: 8px;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;letter-spacing: 1.5px;text-align: left;\"><strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">3月14日</span></strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">：面试季~BIO和NIO别再傻傻分不清楚了</span></p>\n" +
                "             <p style=\"margin-right: 8px;margin-left: 8px;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;letter-spacing: 1.5px;text-align: left;\"><span style=\"font-size: 15px;color: rgb(62, 62, 62);\"><strong>3月15日</strong>：面试季~Redis除了做缓存，还可以怎么用？</span></p>\n" +
                "             <p style=\"margin-right: 8px;margin-left: 8px;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;letter-spacing: 1.5px;text-align: left;\"><strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">3月16日</span></strong><span style=\"font-size: 15px;color: rgb(62, 62, 62);\">：面试季~面试问题线程池你能拿满分嘛？ - 线程池原理与API精析</span></p>\n" +
                "            </blockquote>\n" +
                "           </section>\n" +
                "          </section>\n" +
                "         </section>\n" +
                "        </section>\n" +
                "        <p style=\"white-space: normal;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;letter-spacing: 1.5px;text-align: left;\"><span style=\"font-size: 15px;color: rgb(62, 62, 62);\"></span></p>\n" +
                "        <section style=\"padding-right: 0.5em;padding-left: 0.5em;font-variant-numeric: normal;font-variant-east-asian: normal;white-space: normal;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;letter-spacing: 0.544px;text-align: justify;background-color: rgb(255, 255, 255);widows: 1;line-height: 25.6px;overflow-wrap: break-word !important;\">\n" +
                "         <section class=\"\" powered-by=\"xiumi.us\" style=\"text-align: center;overflow-wrap: break-word !important;\">\n" +
                "          <p style=\"font-family: Arial, Helvetica, sans-serif;overflow-wrap: break-word !important;\"><br style=\"overflow-wrap: break-word !important;\"></p>\n" +
                "          <section style=\"letter-spacing: 0.544px;display: inline-block;min-width: 10%;vertical-align: top;background-color: rgb(255, 202, 0);overflow-wrap: break-word !important;\">\n" +
                "           <section class=\"\" powered-by=\"xiumi.us\" style=\"overflow-wrap: break-word !important;\">\n" +
                "            <section style=\"margin-top: 5px;margin-bottom: -5px;transform: translate3d(5px, 0px, 0px);overflow-wrap: break-word !important;\">\n" +
                "             <section style=\"padding-right: 8px;padding-left: 8px;display: inline-block;min-width: 10%;vertical-align: top;border-style: solid;border-width: 8px 1px 1px;border-radius: 0px;border-color: rgb(62, 62, 62);background-color: rgb(255, 255, 255);overflow-wrap: break-word !important;\">\n" +
                "              <section class=\"\" powered-by=\"xiumi.us\" style=\"overflow-wrap: break-word !important;\">\n" +
                "               <section style=\"overflow-wrap: break-word !important;\">\n" +
                "                <section style=\"padding-right: 8px;padding-left: 8px;text-align: left;overflow-wrap: break-word !important;\">\n" +
                "                 <p style=\"overflow-wrap: break-word !important;\"><strong style=\"overflow-wrap: break-word !important;\"><em style=\"overflow-wrap: break-word !important;\"><strong style=\"letter-spacing: 0.544px;overflow-wrap: break-word !important;\"><em style=\"overflow-wrap: break-word !important;\"><em style=\"font-size: 15px;letter-spacing: 0.544px;overflow-wrap: break-word !important;\"><strong style=\"overflow-wrap: break-word !important;\">福利2&nbsp; Java开发资料包</strong></em></em></strong></em></strong></p>\n" +
                "                </section>\n" +
                "               </section>\n" +
                "              </section>\n" +
                "             </section>\n" +
                "            </section>\n" +
                "           </section>\n" +
                "          </section>\n" +
                "         </section>\n" +
                "        </section>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;font-variant-numeric: normal;font-variant-east-asian: normal;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;background-color: rgb(255, 255, 255);widows: 1;text-align: center;font-family: Arial, Helvetica, sans-serif;letter-spacing: 1.5px;line-height: 1.75em;overflow-wrap: break-word !important;\"><br style=\"overflow-wrap: break-word !important;\"></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;text-indent: 0em;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;letter-spacing: 1px;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;color: rgb(62, 62, 62);overflow-wrap: break-word !important;\">该资料包中主要包括「大数据容器数据库架构技术文档」、「大型公司技术文摘」、「Java开发参考书籍」、「Java开发学习图谱」等内容，<strong style=\"overflow-wrap: break-word !important;\">全方位扩充你的知识体系。</strong></span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;text-indent: 0em;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;letter-spacing: 1px;font-family: Arial, Helvetica, sans-serif;line-height: 1.75em;overflow-wrap: break-word !important;\"><br></p>\n" +
                "        <p style=\"white-space: normal;text-align: center;\"><img class=\"\" data-copyright=\"0\" data-ratio=\"0.7108910891089109\" data-s=\"300,640\" data-type=\"png\" data-w=\"1515\" data-src=\"https://mmbiz.qpic.cn/mmbiz_png/4MXV7svuTWJyzo8YOwAiabJtjNxfMvFjoXWTiaKZMaSIaoj2IqWN00l1QRF0k7GlGt4mmR7libS5HfXl2toXWszhQ/640?wx_fmt=png\"></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;text-indent: 0em;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;text-align: center;letter-spacing: 1px;line-height: 1.75em;font-family: Arial, Helvetica, sans-serif;overflow-wrap: break-word !important;\"><span style=\"color: rgb(62, 62, 62);font-size: 15px;overflow-wrap: break-word !important;\">想要参与Java进阶免费系列直播课</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;text-indent: 0em;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;text-align: center;letter-spacing: 1px;line-height: 1.75em;font-family: Arial, Helvetica, sans-serif;overflow-wrap: break-word !important;\"><span style=\"color: rgb(62, 62, 62);font-size: 15px;overflow-wrap: break-word !important;\">以及获取Java开发工程师资料包的同学，</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;text-indent: 0em;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;text-align: center;letter-spacing: 1px;line-height: 1.75em;font-family: Arial, Helvetica, sans-serif;overflow-wrap: break-word !important;\"><span style=\"color: rgb(62, 62, 62);font-size: 15px;overflow-wrap: break-word !important;\">可以长按扫描下方二维码，</span></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;text-indent: 0em;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;text-align: center;letter-spacing: 1px;line-height: 1.75em;font-family: Arial, Helvetica, sans-serif;overflow-wrap: break-word !important;\"><span style=\"color: rgb(62, 62, 62);font-size: 15px;overflow-wrap: break-word !important;\">添加网易云课堂Java课程助教小姐姐</span></p>\n" +
                "        <p style=\"white-space: normal;text-align: center;\"><img class=\"\" data-copyright=\"0\" data-cropselx1=\"0\" data-cropselx2=\"169\" data-cropsely1=\"0\" data-cropsely2=\"169\" data-ratio=\"1\" data-s=\"300,640\" data-type=\"png\" data-w=\"430\" data-src=\"https://mmbiz.qpic.cn/mmbiz_png/4MXV7svuTWJOZ0Z0ufASWoueJB1XpVJ20OWtBwJpY0ztzRQqstXBflFBebD6X8Q2Vh6O6CXZwHCPniaY5xhaxPQ/640?wx_fmt=png\" style=\"height: 169px;width: 169px;\"></p>\n" +
                "        <p style=\"padding-right: 0.5em;padding-left: 0.5em;text-indent: 0em;white-space: normal;color: rgb(51, 51, 51);font-size: 17px;text-align: center;letter-spacing: 1px;line-height: 1.75em;font-family: Arial, Helvetica, sans-serif;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;color: rgb(62, 62, 62);overflow-wrap: break-word !important;\">免费课程，</span><span style=\"color: rgb(62, 62, 62);font-size: 15px;text-indent: 0em;overflow-wrap: break-word !important;\">名额有限，先到先得~~</span></p> \n" +
                "       </div> ");
       // Elements elements = doc.getElementsByTag("script").remove();
        Elements images = doc.getElementsByTag("img");
        for (Element element : images) {
            String attr = element.attr("data-src");
            System.out.println(attr);
        }
        System.out.println(11);
    }

    @Test
    public void  downlaodImage(){
//        https://mmbiz.qpic.cn/mmbiz_jpg/4MXV7svuTWIaq3k3iaB0iaE4QDicOfhm46DulNKNeQicv4BEDpl2RdFgpaNy38adYcDuNTo5tgP98HFmwibiaP6ibkcvQ/640?wx_fmt=jpeg
//        https://mmbiz.qpic.cn/mmbiz_png/4MXV7svuTWJyzo8YOwAiabJtjNxfMvFjoXWTiaKZMaSIaoj2IqWN00l1QRF0k7GlGt4mmR7libS5HfXl2toXWszhQ/640?wx_fmt=png
//        https://mmbiz.qpic.cn/mmbiz_png/4MXV7svuTWJOZ0Z0ufASWoueJB1XpVJ20OWtBwJpY0ztzRQqstXBflFBebD6X8Q2Vh6O6CXZwHCPniaY5xhaxPQ/640?wx_fmt=png

    }
}