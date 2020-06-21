package no.ssb.dc.content.provider.discarding;

import no.ssb.dc.api.content.ContentStream;
import no.ssb.dc.api.content.ContentStreamBuffer;
import no.ssb.dc.api.content.ContentStreamConsumer;
import no.ssb.dc.api.content.ContentStreamCursor;
import no.ssb.dc.api.content.ContentStreamProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DiscardingContentStream implements ContentStream {

    private final static Logger LOG = LoggerFactory.getLogger(DiscardingContentStream.class);

    final Map<String, ContentStreamBuffer> buffersByName = new ConcurrentHashMap<>();


    @Override
    public String lastPosition(String topic) {
        return null;
    }

    @Override
    public ContentStreamProducer producer(String topic) {
        return new DiscardingContentStreamProducer();
    }

    @Override
    public ContentStreamConsumer consumer(String topic, ContentStreamCursor cursor) {
        return new DiscardingContentStreamConsumer();
    }

    @Override
    public void closeAndRemoveProducer(String topic) {
    }

    @Override
    public void closeAndRemoveConsumer(String topic) {

    }

    @Override
    public void close() throws Exception {

    }
}
