function isEmptyString(str) {
    if(str == "" || str == null || str.length == 0)
    {
        return true;
    }
    return false;
}

function checkEmptyStringAndFocus(str, $elem, msg) {
    if (isEmptyString(str)) {
        alert(msg);
        $elem.focus();
        return true;
    }
    return false;
}