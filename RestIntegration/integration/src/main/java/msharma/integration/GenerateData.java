package innovyt.stayntouch;

// camel-k: language=java

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GenerateData implements Processor  {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody(new Event().createEvent());
    }


}