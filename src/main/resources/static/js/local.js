var expiryTime=45;
var time=expiryTime;

var otpText=document.getElementById("otptime");
var resendPass=document.getElementById("resend");
function updateTime(){

    if (time>=0){
        otpText.innerHTML="OTP expires in :"+time+" secs";
        time--;
    }else{
        otpText.innerHTML="<p style='color:red'>OTP expired<p>";
        resendPass.innerHTML='<a href="#" onclick="otpTime()"><b>Resend OTP</b></a>';
        clearInterval(id);
    }
}
var id = setInterval(updateTime,1000);

function otpTime() {
    resendPass.innerHTML='Resend OTP';
    time=expiryTime;
    id = setInterval(updateTime,1000);
}