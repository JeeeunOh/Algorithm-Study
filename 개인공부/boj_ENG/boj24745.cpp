#include <iostream>
#include <string>
using namespace std;

string sol(string a){
    string s = a;
    if(s=="A" || s=="a"){
        return ".-";
    } else if ( s=="B" || s=="b"){
        return "-...";
    }else if ( s=="C" || s=="c"){
        return "-.-.";
    }else if ( s=="D" || s=="d"){
        return "-..";
    }else if ( s=="E" || s=="e"){
        return ".";
    }else if ( s=="F" || s=="f"){
        return "..-.";
    }else if ( s=="G" || s=="g"){
        return "--.";
    }else if ( s=="H" || s=="h"){
        return "....";
    }else if ( s=="I" || s=="i"){
        return "..";
    }else if ( s=="J" || s=="j"){
        return ".---";
    }else if ( s=="K" || s=="k"){
        return "-.-";
    }else if ( s=="L" || s=="l"){
        return ".-..";
    }else if ( s=="M" || s=="m"){
        return "--";
    }else if ( s=="N" || s=="n"){
        return "-.";
    }else if ( s=="O" || s=="o"){
        return "---";
    }else if ( s=="P" || s=="p"){
        return ".--.";
    }else if ( s=="Q" || s=="q"){
        return "--.-";
    }else if ( s=="R" || s=="r"){
        return ".-.";
    }else if ( s=="S" || s=="s"){
        return "...";
    }else if ( s=="T" || s=="T"){
        return "-";
    }else if ( s=="U" || s=="u"){
        return "..-";
    }else if ( s=="V" || s=="v"){
        return "...-";
    }else if ( s=="W" || s=="w"){
        return ".--";
    }else if ( s=="X" || s=="x"){
        return "-..-";
    }else if ( s=="Y" || s=="y"){
        return "-.--";
    }else if ( s=="Z" || s=="z"){
        return "--..";
    }else if ( s=="1"){
        return ".----";
    }else if ( s=="2"){
        return "..---";
    }else if ( s=="3"){
        return "...--";
    }else if ( s=="4"){
        return "....-";
    }else if ( s=="5"){
        return ".....";
    }else if ( s=="6"){
        return "-....";
    }else if ( s=="7"){
        return "--...";
    }else if ( s=="8"){
        return "---..";
    }else if ( s=="9"){
        return "----.";
    }

}

int main(){
    string s;
    string temp="";

    cin >> s;

    for(int i=0 ;i<s.length(); i++){
        string input=s[i];
        temp+=sol(input);
    }

    for(int i=0 ; i<temp.length()/2; i++){
        if(temp[i]!=temp[temp.length()-1-i]){
            cout << "NO" << endl;
            return 0;
        }
    }

    cout << "YES" << endl;
}