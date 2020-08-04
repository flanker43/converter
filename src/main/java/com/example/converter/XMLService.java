package com.example.converter;

import com.example.converter.dto.ExchangeRates;
import com.example.converter.repos.ExchangeRatesRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class XMLService {
    private final Logger logger = LoggerFactory.getLogger(XMLService.class);

    @Autowired
    private ExchangeRatesRepo exchangeRatesRepo;

    public ExchangeRates parseXml() {

        RestClient restClient = new RestClient();

//        ExchangeRates exchangeRates = null;

        try {
            String URL = restClient.get("http://www.cbr.ru/scripts/XML_daily.asp");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(URL)));

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getDocumentElement().getElementsByTagName("Valute");

            //List<ExchangeRates> exchangeValute = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {

                Node node = nodeList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elem = (Element) node;
                    ExchangeRates exchangeRates = new ExchangeRates(
                            String.valueOf(elem.getAttribute("ID")),
                            Integer.parseInt(elem.getElementsByTagName("NumCode").item(0).getTextContent()),
                            elem.getElementsByTagName("CharCode").item(0).getTextContent(),
                            Integer.parseInt(elem.getElementsByTagName("Nominal").item(0).getTextContent()),
                            elem.getElementsByTagName("Name").item(0).getTextContent(),
                            (Double) NumberFormat.getInstance(Locale.FRANCE).parse((elem.getElementsByTagName("Value").item(0).getTextContent()))
                    );
                    exchangeRatesRepo.save(exchangeRates);
                    //exchangeValute.add(exchangeRates);
                }

            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
            logger.error("Problem",ex);
        }

        return null;
    }
}
