/*
 * tn.h - token type
 * programmer - 팀 6: 1876375정하늘, 1971039이진경, 1971051최수정
 * date - 2021.04.28
 */

/* 토큰 타입 정의 */
enum tokentypes {TEOF,
                TCONST, TELSE, TIF, TINT, TRETURN, TVOID, TWHILE,
                TADD, TSUB, TMUL, TDIV, TMOD,
                TASSIGN, TADDASSIGN, TSUBASSIGN, TMULASSIGN,TDIVASSIGN, TMODASSIGN,
                TNOT, TAND, TOR,
                TEQUAL, TNOTEQU, TLESS, TGREAT, TLESSE, TGREATE,
                TINC, TDEC, 
                TBRASL, TBRASR, TBRAML, TBRAMR, TBRALL, TBRALR, TCOMMA, TSEMICOLON,
                TIDENT,
                TNUMBER, TRNUMBER,
                TSTRING, TCHAR, TSTRINGVALUE, TCHARVALUE,
                TLONGIDERR, TSWDIGITERR, TILLSYMBOLERR};