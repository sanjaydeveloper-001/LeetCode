char* intToRoman(int num) {
    char* rn[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    int v[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
    char *result=(char*)malloc(20*sizeof(char));
    result[0]='\0';
    for(int i=0;i<13;i++){
        while(num >= v[i]){
            strcat(result,rn[i]);
            num-=v[i];
        }
    }
    return result;
}