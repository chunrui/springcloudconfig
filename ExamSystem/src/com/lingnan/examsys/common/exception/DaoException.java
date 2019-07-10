package com.lingnan.examsys.common.exception;
/**
 * Dao异常类
 * @author Hellow
 *
 */
public class DaoException extends RuntimeException{
	/**
	 * 构造方法
	 * @param arg0 产生异常的原因
	 */
	public DaoException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * 构造方法
	 * @param arg0 异常的详细信息
	 * @param arg1 产生异常的原因
	 */
	public DaoException(String arg0,Throwable arg1) {
		super(arg0,arg1);
	}
}
