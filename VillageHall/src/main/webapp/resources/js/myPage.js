const mypage = document.getElementById("mypage")
mypage.addEventListener("click", function(){
    const subMenu = document.getElementById("sub-menu");

    if(subMenu.style.display == 'none'){
       subMenu.style.display = "block";

    }else{
        subMenu.style.display = "none";
    }
    
})