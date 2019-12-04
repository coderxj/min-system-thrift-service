package com.acme.service.minsystemservice.service;


import com.acme.service.Exception.MinSystemException;

/**
 * @author acme
 * @date 2019/12/1 9:06 PM
 */
public interface ICalculate {
    double calculateAdd(double num1, double num2);
    double calculateSub(double num1, double num2);
    double calculateMul(double num1, double num2);
    double calculateDiv(double num1, double num2) throws MinSystemException;
}
