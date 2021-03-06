package com.lithium.ldn.starql.parsers;

import com.lithium.ldn.starql.exceptions.InvalidQueryException;
import com.lithium.ldn.starql.exceptions.QueryValidationException;
import com.lithium.ldn.starql.models.QlSelectStatement;
import com.lithium.ldn.starql.models.QlWhereClause;
import com.lithium.ldn.starql.validation.QlConstraintsClauseValidator;
import com.lithium.ldn.starql.validation.QlSelectStatementValidator;


/**
 * Converts query strings into query markup specific data structures.
 * 
 * @author David Esposito
 */
public interface QueryMarkupManager {

	/**
	 * Converts a StarQL SELECT statement string into a POJO. A no-op validator will be used.
	 * @param query StarQL SELECT statement. Should not end in a semicolon. Must not be {@code null}
	 * @return The select statement representing the provided query. Will never be {@code null}.
	 * @throws InvalidQueryException Please see exception and fix query syntax.
	 */
	QlSelectStatement parseQlSelect(String query) throws InvalidQueryException, QueryValidationException;
	
	/**
	 * Converts a StarQL SELECT statement string into a POJO.
	 * @param query StarQL SELECT statement. Should not end in a semicolon. Must not be {@code null}
	 * @param validator The validator to be used once the query is successfully parsed. Must not be {@code null}
	 * @return The select statement representing the provided query. Will never be {@code null}.
	 * @throws InvalidQueryException Please see exception and fix query syntax.
	 */
	QlSelectStatement parseQlSelect(String query, QlSelectStatementValidator validator) 
			throws InvalidQueryException, QueryValidationException;
	
	/**
	 * Converts a StarQL Constraints clause string into a POJO. A no-op validator will be used.
	 * @param query StarQL Constraints clause. Should not end in a semicolon. Should not start with 
	 * 		white space. Should not start with the constant "WHERE". Must not be {@code null}
	 * @return The Constraints clause representing the provided query. Will never be {@code null}
	 * @throws InvalidQueryException Please see exception and fix query syntax.
	 */
	QlWhereClause parseQlConstraintsClause(String query) throws InvalidQueryException, QueryValidationException;
	
	/**
	 * Converts a StarQL Constraints clause string into a POJO.
	 * @param query StarQL Constraints clause. Should not end in a semicolon. Should not start with 
	 * 		white space. Should not start with the constant "WHERE". Must not be {@code null}
	 * @param validator The validator to be used once the query is successfully parsed. 
	 * 		Must not be {@code null}
	 * @return The Constraints clause representing the provided query. Will never be {@code null}
	 * @throws InvalidQueryException Please see exception and fix query syntax.
	 */
	QlWhereClause parseQlConstraintsClause(String query, QlConstraintsClauseValidator validator) 
			throws InvalidQueryException, QueryValidationException;
}
