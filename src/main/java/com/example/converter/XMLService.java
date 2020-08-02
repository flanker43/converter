package com.example.converter;

import com.example.converter.dto.ExchangeRatesXml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class XMLService {
    private final Logger logger = LoggerFactory.getLogger(XMLService.class);


    public ExchangeRatesXml parseXml() {

        ExchangeRatesXml exchangeRatesXml = null;

        try {
            String URL = "http://www.cbr.ru/scripts/XML_daily.asp";

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Valute");

            List<ExchangeRatesXml> valute = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    ExchangeRatesXml exchangeRatesXml1 = new ExchangeRatesXml(
                            Integer.parseInt(elem.getElementsByTagName("id").item(0).getTextContent()),
                            elem.getElementsByTagName("name").item(0).getTextContent(),
                            elem.getElementsByTagName("charCode").item(0).getTextContent(),
                            Double.parseDouble(elem.getElementsByTagName("value").item(0).getTextContent()),
                            Integer.parseInt(elem.getElementsByTagName("nominal").item(0).getTextContent())
                    );
                    valute.add(exchangeRatesXml1);
                }
            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return exchangeRatesXml;
    }
}
