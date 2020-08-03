package com.example.converter;

import com.example.converter.dto.ExchangeRates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class XMLService {
    private final Logger logger = LoggerFactory.getLogger(XMLService.class);


    public ExchangeRates parseXml() {

        RestClient restClient = new RestClient();

        ExchangeRates exchangeRates = null;

        try {
            String URL = restClient.get("www.cbr.ru/scripts/XML_daily.asp");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Valute");

            List<ExchangeRates> exchangeValute = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    exchangeRates = new ExchangeRates(
                            elem.getAttribute("ValCurs Date"),
                            Integer.parseInt(elem.getAttribute("Valute ID")),
                            Integer.parseInt(elem.getElementsByTagName("NumCode").item(0).getTextContent()),
                            elem.getElementsByTagName("name").item(0).getTextContent(),
                            elem.getElementsByTagName("charCode").item(0).getTextContent(),
                            Double.parseDouble(elem.getElementsByTagName("value").item(0).getTextContent()),
                            Integer.parseInt(elem.getElementsByTagName("nominal").item(0).getTextContent())
                    );
                    exchangeValute.add(exchangeRates);
                }
            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return exchangeRates;
    }
}
