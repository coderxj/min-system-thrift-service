namespace java com.acme.service.service

include 'Dto.thrift'
include 'Exception.thrift'

service TCalculate {
    Dto.ExpressionResult calculate(1:Dto.Expression exp) throws (1:Exception.MinSystemException ex);
}