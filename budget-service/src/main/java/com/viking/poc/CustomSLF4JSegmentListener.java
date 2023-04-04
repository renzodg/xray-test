package com.viking.poc;

import com.amazonaws.xray.entities.Entity;
import com.amazonaws.xray.entities.Segment;
import com.amazonaws.xray.entities.StringValidator;
import com.amazonaws.xray.listeners.SegmentListener;
import org.slf4j.MDC;

public class CustomSLF4JSegmentListener implements SegmentListener {
  private static final String TRACE_ID_KEY = "AWS-XRAY-TRACE-ID";

  private String prefix;

  public CustomSLF4JSegmentListener() {
    this(TRACE_ID_KEY);
  }

  public CustomSLF4JSegmentListener(String prefix) {
    this.prefix = prefix;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  @Override
  public void onSetEntity(Entity oldEntity, Entity newEntity) {
    if (newEntity == null) {
      MDC.remove(TRACE_ID_KEY);
      return;
    }

    Segment segment =  newEntity instanceof Segment ? ((Segment) newEntity) : newEntity.getParentSegment();

    if (segment != null && segment.getTraceId() != null && newEntity.getId() != null) {
      String fullPrefix = StringValidator.isNullOrBlank(this.prefix) ? "" : this.prefix + ": ";
      MDC.put(TRACE_ID_KEY, fullPrefix + segment.getTraceId() + "@" + newEntity.getId());
    } else {
      MDC.remove(TRACE_ID_KEY);  // Ensure traces don't spill over to unlinked messages
    }
  }

  @Override
  public void onClearEntity(Entity entity) {
    MDC.remove(TRACE_ID_KEY);
  }
}
