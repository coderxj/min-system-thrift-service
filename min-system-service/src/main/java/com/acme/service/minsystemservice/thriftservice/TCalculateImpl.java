package com.acme.service.minsystemservice.thriftservice;

import com.acme.service.Dto.Expression;
import com.acme.service.Dto.ExpressionResult;
import com.acme.service.Exception.MinSystemException;
import com.acme.service.minsystemservice.service.ICalculate;
import com.acme.service.service.TCalculate;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author acme
 * @date 2019/7/24 11:41 PM
 */
@Service
public class TCalculateImpl implements TCalculate.Iface {

    @Autowired
    private ICalculate iCalculate;

    @Override
    public ExpressionResult calculate(Expression exp) throws MinSystemException, TException {
        switch (exp.getOp()){
            case ADD: return new ExpressionResult(iCalculate.calculateAdd(exp.getNum1() , exp.getNum2()));
            case SUB: return new ExpressionResult(iCalculate.calculateSub(exp.getNum1() , exp.getNum2()));
            case MUL: return new ExpressionResult(iCalculate.calculateMul(exp.getNum1() , exp.getNum2()));
            case DIV: return new ExpressionResult(iCalculate.calculateDiv(exp.getNum1() , exp.getNum2()));
        }
        return null;
    }
}
