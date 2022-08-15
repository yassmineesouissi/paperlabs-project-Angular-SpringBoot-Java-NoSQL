 
  exports.myFunction2 = function myFunction2(){
    window.$crisp=[];
    window.CRISP_WEBSITE_ID="d7c42433-c5a6-47b0-9a14-dd91f919fee5";
    (function(){d=document;
    sqPaymentScript=d.createElement("script");
    sqPaymentScript.src="https://client.crisp.chat/l.js";
    $crisp.push(["safe", true]);
    sqPaymentScript.async=false;
    document.getElementsByTagName("section")[0].appendChild(sqPaymentScript);
    })
    ();
}
