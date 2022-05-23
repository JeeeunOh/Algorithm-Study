%{
#include <stdio.h>
#include <ctype.h>
#include <malloc.h>

/*yacc source for Mini C*/
void semantic(int);
%}

%token TCONST TELSE TIF TINT TRETURN  TVOID TWHILE TILLIDENT TONECMT TMULCMT
%token TPLUS TMINUS TSTAR TSLASH TMOD TASSIGN TADDASSIGN TSUBASSIGN TMULASSIGN TDIVASSIGN TMODASSGIN TNOT TAND TOR TEQUAL TNOTEQU TLESS TOVER TLESSE TOVERE TINC TDEC
%token TOSBRA TCSBRA TCOMMA TOMBRA TCMBRA TOLBRA TCLBRA TSEMI

%nonassoc LOWER_THAN_ELSE 
%nonassoc TELSE

%%
mini_c 			: translation_unit			
translation_unit 	: external_dcl				
			| translation_unit external_dcl
external_dcl 		: function_def			
		  	| declaration				
function_def 		: function_header compound_st		
function_header 	: dcl_spec function_name formal_param	
dcl_spec 		: dcl_specifiers		
dcl_specifiers 		: dcl_specifier			
		 	| dcl_specifiers dcl_specifier	
dcl_specifier 		: type_qualifier		
			| type_specifier			
type_qualifier 		: tconst				
type_specifier 		: tint				
		 	| tvoid					
function_name 	: tident				
formal_param 		: '(' opt_formal_param ')' 	
opt_formal_param 	: formal_param_list		
		   	|				
formal_param_list 	: param_dcl			
		    	| formal_param_list ',' param_dcl 	
param_dcl 		: dcl_spec declarator		
compound_st 		: '{' opt_dcl_list opt_stat_list '}'
opt_dcl_list 		: declaration_list	
			|				
declaration_list 	: declaration			
			| declaration_list declaration 	
declaration 		: dcl_spec init_dcl_list ';'	
init_dcl_list 		: init_declarator			
			| init_dcl_list ',' init_declarator 	
init_declarator 	: declarator				
		 	| declarator '=' tnumber	
declarator 		: tident					
	     		| tident '[' opt_number ']'	
opt_number 		: tnumber			
	     		|				
opt_stat_list 		: statement_list		
		 	|				
statement_list 		: statement			
		 	| statement_list statement 	
statement 		: compound_st			
	   		| expression_st			
	   		| if_st				
	   		| while_st				
	   		| return_st			
	   		;
expression_st 	: opt_expression ';'		
opt_expression 	: expression				
		 	|					
if_st 			: tif '(' expression ')' statement  %prec LOWER_THAN_ELSE
			| tif '(' expression ')' statement telse statement
while_st 		: twhile '(' expression ')' statement 	
return_st 		: treturn opt_expression ';'	
expression 		: assignment_exp		
assignment_exp 	: logical_or_exp			
			| unary_exp '=' assignment_exp 
			| unary_exp taddAssign assignment_exp 	
			| unary_exp tsubAssign assignment_exp 	
			| unary_exp tmulAssign assignment_exp 	{semantic(58);}
			| unary_exp tdivAssign assignment_exp 	{semantic(59);}
			| unary_exp tmodAssign assignment_exp 	{semantic(60);}
			;
logical_or_exp 	: logical_and_exp			{semantic(61);}
			| logical_or_exp tor logical_and_exp 	{semantic(62);};
logical_and_exp 	: equality_exp				{semantic(63);}
		 	| logical_and_exp tand equality_exp 	{semantic(64);};
equality_exp 		: relational_exp			{semantic(65);}
			| equality_exp tequal relational_exp 	{semantic(66);}
			| equality_exp tnotequ relational_exp 	{semantic(67);};
relational_exp 	: additive_exp 			{semantic(68);}
			| relational_exp '>' additive_exp 	{semantic(69);}
			| relational_exp '<' additive_exp 	{semantic(70);}
			| relational_exp tgreate additive_exp 	{semantic(71);}
			| relational_exp tlesse additive_exp 	{semantic(72);};
additive_exp 		: multiplicative_exp			{semantic(73);}
			| additive_exp '+' multiplicative_exp 	{semantic(74);}
			| additive_exp '-' multiplicative_exp 	{semantic(75);};
multiplicative_exp 	: unary_exp				{semantic(76);}
		    	| multiplicative_exp '*' unary_exp 	{semantic(77);}
		    	| multiplicative_exp '/' unary_exp 	{semantic(78);}
		    	| multiplicative_exp '%' unary_exp 	{semantic(79);};
unary_exp 		: postfix_exp				{semantic(80);}
	   		| '-' unary_exp				{semantic(81);}
	   		| '!' unary_exp				{semantic(82);}
	   		| tinc unary_exp			{semantic(83);}
	   		| tdec unary_exp			{semantic(84);};
postfix_exp 		: primary_exp				{semantic(85);}
	      		| postfix_exp '[' expression ']' 	{semantic(86);}
	      		| postfix_exp '(' opt_actual_param ')' 	{semantic(87);}
	      		| postfix_exp tinc			{semantic(88);}
	      		| postfix_exp tdec			{semantic(89);};
opt_actual_param 	: actual_param				{semantic(90);}
		  	|					{semantic(91);};
actual_param 		: actual_param_list			{semantic(92);};
actual_param_list 	: assignment_exp			{semantic(93);}
		   	| actual_param_list ',' assignment_exp 	{semantic(94);};
primary_exp 		: tident				{semantic(95);}
	     		| tnumber				{semantic(96);}
	     		| '(' expression ')'			{semantic(97);};
%%

void semantic(int n)
{	
	printf("reduced rule number = %d\n",n);
}