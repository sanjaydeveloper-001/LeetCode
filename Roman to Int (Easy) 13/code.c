int romanToInt(char* s) {
    int result = 0, i = 0;
    while (s[i] != '\0') {
        switch (s[i]) {
        case 'M':
            result += 1000;
            break;

        case 'D':
            if (s[i + 1] == 'M')
                result -= 500;
            else
                result += 500;
            break;

        case 'C':
            if (s[i + 1] == 'M' || s[i + 1] == 'D')
                result -= 100;
            else
                result += 100;
            break;

        case 'L':
            if (s[i + 1] == 'C' || s[i + 1] == 'M' || s[i + 1] == 'D')
                result -= 50;
            else
                result += 50;
            break;

        case 'X':
            if (s[i + 1] == 'L' || s[i + 1] == 'C' || s[i + 1] == 'D' ||
                s[i + 1] == 'M')
                result -= 10;
            else
                result += 10;
            break;

        case 'V':
            if (s[i + 1] == 'X' || s[i + 1] == 'L' || s[i + 1] == 'C' ||
                s[i + 1] == 'D' || s[i + 1] == 'M')
                result -= 5;
            else
                result += 5;
            break;

        case 'I':
            if (s[i + 1] == 'V' || s[i + 1] == 'X' || s[i + 1] == 'L' ||
                s[i + 1] == 'C' || s[i + 1] == 'D' || s[i + 1] == 'M')
                result -= 1;
            else
                result += 1;
            break;
        }
        i++;
    }
    return result;
}