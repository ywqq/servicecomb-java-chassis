package org.apache.servicecomb.transport.rest.vertx.accesslog.element.creator;

import java.util.HashMap;
import java.util.Map;

import org.apache.servicecomb.transport.rest.vertx.accesslog.element.AccessLogItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.ResponseSizeItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.DatetimeConfigurableItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.DurationMillisecondItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.DurationSecondItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.FirstLineOfRequestItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.LocalHostItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.LocalPortItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.HttpMethodItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.QueryStringItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.RemoteHostItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.HttpStatusItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.TraceIdItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.UrlPathWithQueryItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.UrlPathItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.element.impl.RequestProtocolItem;
import org.apache.servicecomb.transport.rest.vertx.accesslog.parser.AccessLogItemLocation;
import org.apache.servicecomb.transport.rest.vertx.accesslog.placeholder.AccessLogItemTypeEnum;

public class SimpleAccessLogItemCreator implements AccessLogItemCreator {
  private static final Map<AccessLogItemTypeEnum, AccessLogItem> SIMPLE_ACCESSLOG_ITEM_MAP = new HashMap<>();

  static {
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.HTTP_METHOD, new HttpMethodItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.HTTP_STATUS, new HttpStatusItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.DURATION_IN_SECOND, new DurationSecondItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.DURATION_IN_MILLISECOND, new DurationMillisecondItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.REMOTE_HOSTNAME, new RemoteHostItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.LOCAL_HOSTNAME, new LocalHostItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.LOCAL_PORT, new LocalPortItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.RESPONSE_SIZE, new ResponseSizeItem("0"));
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.RESPONSE_SIZE_CLF, new ResponseSizeItem("-"));
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.FIRST_LINE_OF_REQUEST, new FirstLineOfRequestItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.URL_PATH, new UrlPathItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.QUERY_STRING, new QueryStringItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.URL_PATH_WITH_QUERY, new UrlPathWithQueryItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.REQUEST_PROTOCOL, new RequestProtocolItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.DATETIME_DEFAULT, new DatetimeConfigurableItem());
    SIMPLE_ACCESSLOG_ITEM_MAP.put(AccessLogItemTypeEnum.SCB_TRACE_ID, new TraceIdItem());
  }

  @Override
  public AccessLogItem create(String rawPattern, AccessLogItemLocation location) {
    return SIMPLE_ACCESSLOG_ITEM_MAP.get(location.getPlaceHolder());
  }
}