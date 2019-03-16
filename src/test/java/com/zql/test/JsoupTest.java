package com.zql.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by 张启磊 on 2019-3-16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JsoupTest {
    @org.junit.Test
    public void test() {
        String s = "<div class=\"rich_media_content \" id=\"js_content\"> \n" +
                " <p data-mpa-powered-by=\"yiban.io\"><span style=\"font-size: 15px;letter-spacing: 1px;background-color: rgb(255, 255, 255);widows: 1;\"></span><span style=\"font-size: 15px;letter-spacing: 1px;background-color: rgb(255, 255, 255);widows: 1;\">搞了N年Java，仍有不少朋友</span><strong style=\"font-size: 15px;letter-spacing: 1px;background-color: rgb(255, 255, 255);widows: 1;overflow-wrap: break-word !important;\">困惑</strong><span style=\"font-size: 15px;letter-spacing: 1px;background-color: rgb(255, 255, 255);widows: 1;\">：用了很多年Dubbo，觉得自己挺厉害，跳槽面试时一问RPC，一问</span><span yahei=\"yahei\" sans=\"sans\" helvetica=\"helvetica\" px=\"px\" normal=\"normal\" none=\"none\" left=\"left\" gb=\"gb\" neue=\"neue\" style=\"font-size: 15px;letter-spacing: 1px;widows: 1;float: none;color: rgb(0, 0, 0);\">底层</span><span style=\"font-size: 15px;letter-spacing: 1px;background-color: rgb(255, 255, 255);widows: 1;\">通讯，一问NIO和AIO，就一脸懵逼，到底该怎么办？</span></p> \n" +
                " <section class=\"xmteditor\" style=\"display:none;\" data-tools=\"新媒体管家\" data-label=\"powered by xmt.cn\"></section> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"letter-spacing: 1px;max-width: 100%;color: rgb(204, 0, 0);font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">画外音：大家有没有这样的感触？Dubbo用得很熟，但底层却很模糊</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">学习Netty，对理解Java底层通讯机制有很大帮助。对于Java开发者来说，如果没有搞透Netty，谁敢说自己是Java专家？</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"letter-spacing: 1px;max-width: 100%;color: rgb(204, 0, 0);font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">画外音：面试时，一般都会问Netty相关的问题，如果不会的话，会非常吃亏</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;\"><strong style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">掌握Netty，是深入Java技术栈的必经之路。</span></strong></span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;\"><strong style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">那到底怎么样深入的学习Netty技术呢？</span></strong></span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">这里推荐大家关注<strong style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\">李兴华</strong>老师最新的<strong style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\">免费</strong>Netty学习视频，内容包括：</span></p> \n" +
                " <ul class=\" list-paddingleft-2\" style=\"\"> \n" +
                "  <li><p style=\"max-width: 100%;min-height: 1em;line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">Java网络通信基础</span></p></li> \n" +
                "  <li><p style=\"max-width: 100%;min-height: 1em;line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">Netty网络通讯</span></p></li> \n" +
                "  <li><p style=\"max-width: 100%;min-height: 1em;line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">Netty开发HTTP实战</span></p></li> \n" +
                " </ul> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"letter-spacing: 1px;max-width: 100%;color: rgb(204, 0, 0);font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">画外音：这些都是Java通讯最基础，也是最核心的内容</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;\"><strong style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">李兴华是谁？</span></strong></span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">李兴华，有多年Java底层经验，出版过N本Java著作，是领域内最资深的“网红讲师”。</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"letter-spacing: 1px;max-width: 100%;color: rgb(204, 0, 0);font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">画外音：很多朋友应该都认识这个行业大拿吧？</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">李兴华出版的<strong style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\">Java经典书籍</strong>，大家都耳熟能详：</span></p> \n" +
                " <ul class=\" list-paddingleft-2\" style=\"\"> \n" +
                "  <li><p style=\"max-width: 100%;min-height: 1em;line-height: 1.5em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">《初级学Java》</span></p></li> \n" +
                "  <li><p style=\"max-width: 100%;min-height: 1em;line-height: 1.5em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">《Java开发实战经典》</span></p></li> \n" +
                "  <li><p style=\"max-width: 100%;min-height: 1em;line-height: 1.5em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">《Java Web开发实战经典》</span></p></li> \n" +
                "  <li><p style=\"max-width: 100%;min-height: 1em;line-height: 1.5em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">《Android开发实战经典》</span></p></li> \n" +
                "  <li><p style=\"max-width: 100%;min-height: 1em;line-height: 1.5em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">《Oracle开发实战经典》</span></p></li> \n" +
                "  <li><p style=\"max-width: 100%;min-height: 1em;line-height: 1.5em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">《Java核心技术精讲》</span></p></li> \n" +
                " </ul> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">一系列畅销书，都出自李兴华老师之手。</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"letter-spacing: 1px;max-width: 100%;color: rgb(204, 0, 0);font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">画外音：沉下心钻研的技术人，值得尊敬</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.5em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;\"><strong style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">有没有更详细的视频提纲？</span></strong></span></p> \n" +
                " <p border-box=\"border-box\" break-word=\"break-word\" yahei=\"yahei\" sans=\"sans\" helvetica=\"helvetica\" rgb=\"rgb\" px=\"px\" important=\"important\" em=\"em\" normal=\"normal\" both=\"both\" none=\"none\" left=\"left\" ui=\"ui\" gb=\"gb\" sc=\"sc\" neue=\"neue\" style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><img class=\"\" data-copyright=\"0\" data-ratio=\"1.7786666666666666\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"750\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/hObz0jenxicDdgmgibudyoIEqibOcwUCibwJm3xCIiakq8vw4pAsLkSMClAT7k2bWDibNoQhwwlv4Oo8H9M0TVHNwrNg/640?wx_fmt=jpeg\" style=\"box-sizing: border-box !important;overflow-wrap: break-word !important;width: 366px !important;visibility: visible !important;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">希望这几个小时的免费视频能够帮助到大家，学到东西，解决工作中的实际问题。</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"letter-spacing: 1px;max-width: 100%;color: rgb(204, 0, 0);font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">画外音：让我猜一下，别只顾着收藏，D盘里的知识不是你脑中的知识，一定要花几个小时认真看完！</span></p> \n" +
                " <p border-box=\"border-box\" break-word=\"break-word\" yahei=\"yahei\" sans=\"sans\" helvetica=\"helvetica\" rgb=\"rgb\" px=\"px\" important=\"important\" em=\"em\" normal=\"normal\" both=\"both\" none=\"none\" left=\"left\" ui=\"ui\" gb=\"gb\" sc=\"sc\" neue=\"neue\" style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;\"><strong style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">如何领取免费视频资料？</span></strong></span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;\"><span style=\"font-size: 15px;max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">扫码<strong style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\">添加<span yahei=\"yahei\" sans=\"sans\" helvetica=\"helvetica\" px=\"px\" normal=\"normal\" none=\"none\" left=\"left\" gb=\"gb\" neue=\"neue\" style=\"font-size: 15px;max-width: 100%;float: none;color: rgb(0, 0, 0);background-color: transparent;box-sizing: border-box !important;overflow-wrap: break-word !important;display: inline !important;\">小助理</span></strong>领取，</span></span><span style=\"font-size: 15px;\"><strong><span style=\"font-size: 15px;max-width: 100%;letter-spacing: 1px;color: rgb(204, 0, 0);box-sizing: border-box !important;overflow-wrap: break-word !important;\">仅限300个</span></strong></span><span style=\"font-size: 15px;\"><span style=\"font-size: 15px;max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">名额（小助理通过申请之后会逐个发送资料，精力有限，需要的抓紧速度~）</span></span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;\"><span style=\"font-size: 15px;max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br></span></span></p> \n" +
                " <p style=\"text-align: center;\"><img class=\"\" data-copyright=\"0\" data-ratio=\"0.9954954954954955\" data-s=\"300,640\" data-type=\"jpeg\" data-w=\"444\" data-src=\"https://mmbiz.qpic.cn/mmbiz_jpg/hObz0jenxicA6lCXabuq2uZOb0zIeWJ8ADLXxaNf0ZKThz2a8ckBib5ca9eT8Sbt0NXJXaOckJERydTBExVblquQ/640?wx_fmt=jpeg\" style=\"width:50%;height:auto;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;white-space: normal;widows: 1;text-align: center;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;\"><span style=\"color: rgb(204, 0, 0);\"><strong><span style=\"max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">扫码</span></strong></span><span style=\"max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">加小助手</span></span><br></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;white-space: normal;widows: 1;text-align: center;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;letter-spacing: 1px;font-size: 15px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">免费学习Netty视频</span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br style=\"max-width: 100%;box-sizing: border-box !important;overflow-wrap: break-word !important;\"></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);line-height: 1.75em;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"font-size: 15px;\"><span style=\"max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">和志同道合的人一起深入讨论与学习Java技术，这是热爱学习的你应得的，也帮忙</span><span style=\"max-width: 100%;letter-spacing: 1px;color: rgb(204, 0, 0);box-sizing: border-box !important;overflow-wrap: break-word !important;\">转</span><span style=\"max-width: 100%;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\">给需要的朋友哦！</span></span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;font-size: 14px;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br></span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, 'Helvetica Neue', 'PingFang SC', 'Hiragino Sans GB', 'Microsoft YaHei UI', 'Microsoft YaHei', Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: justify;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;font-size: 14px;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><br></span></p> \n" +
                " <p style=\"max-width: 100%;min-height: 1em;color: rgb(51, 51, 51);font-family: -apple-system-font, BlinkMacSystemFont, &quot;Helvetica Neue&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, Arial, sans-serif;font-size: 17px;font-variant-numeric: normal;font-variant-east-asian: normal;letter-spacing: 0.544px;line-height: 27.2px;text-align: right;white-space: normal;widows: 1;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;\"><span style=\"max-width: 100%;font-size: 14px;letter-spacing: 1px;box-sizing: border-box !important;overflow-wrap: break-word !important;\"><img class=\"__bg_gif\" data-copyright=\"0\" data-cropselx1=\"15\" data-cropselx2=\"219\" data-cropsely1=\"0\" data-cropsely2=\"49\" data-ratio=\"0.2234375\" data-s=\"300,640\" data-type=\"gif\" data-w=\"640\" data-src=\"https://mmbiz.qpic.cn/mmbiz_gif/bUbjNpoO3nHuAjZRzBicNmBEwBZ4aAUjvGTG5MIGB9BFTErJFTcoLFRNWEr3D9KVg5P9hSQJuyPWMgLwS6bJmFg/640?wx_fmt=gif\" style=\"color: rgb(102, 102, 102);font-size: 14px;font-variant-numeric: normal;font-variant-east-asian: normal;line-height: 28px;text-align: right;widows: 1;letter-spacing: 0.544px;white-space: normal;background-color: rgb(255, 255, 255);box-sizing: border-box !important;overflow-wrap: break-word !important;visibility: visible !important;width: 219px !important;\"></span></p> \n" +
                "</div>";
        Document doc = Jsoup.parse(s);
        Element el = doc.select(".rich_media_content").get(0);
        Elements imgUrls = el.select("img");
        for (int i = 0; i < imgUrls.size(); i++) {
            //每个图片url都保存为一个dto
            String imgOldUrl = imgUrls.get(i).attr("data-src");
            //把data_src属性删除
            el.getElementsByTag("img").get(i).removeAttr("data-src");
            //增加src属性并把src添加进去，图片就能正常显示
            el.getElementsByTag("img").get(i).select("img").attr("src", imgOldUrl);
        }
    }
}