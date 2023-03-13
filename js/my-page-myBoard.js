// 탭 버튼 요소 선택
const tabButtons = document.querySelectorAll(".tab button");

// 탭 내용 요소 선택
const tabContents = document.querySelectorAll(".tabcontent");

// 탭 버튼 클릭 이벤트 처리
tabButtons.forEach(function(button) {
  button.addEventListener("click", function() {
    // 탭 버튼 색상과 폰트 굵기 변경
    tabButtons.forEach(function(button) {
      button.classList.remove("active");
      button.style.color = "black";
      button.style.fontWeight = "normal";
    });
    this.classList.add("active");
    this.style.color = "white";
    this.style.fontWeight = "bold";

    // 탭 내용 보이기/숨기기
    const targetContentId = this.getAttribute("data-tab");
    tabContents.forEach(function(content) {
      if (content.id == targetContentId) {
        content.style.display = "block";
      } else {
        content.style.display = "none";
      }
    });
  });
});


// 마이페이지 텝
const mypage = document.getElementById("mypage")
mypage.addEventListener("click", function(){
    const subMenu = document.getElementById("sub-menu");

    if(subMenu.style.display == 'none'){
       subMenu.style.display = "block";

    }else{
        subMenu.style.display = "none";
    }
    
});


// 페이징용 js
const postsList = document.querySelector('.posts-list');
const pagination = document.querySelector('.pagination');
let currentPage = 1;
let totalPages = 1;
const postsPerPage = 2;

function showPage(pageNumber) {
  const startIndex = (pageNumber - 1) * postsPerPage;
  const endIndex = startIndex + postsPerPage;
  const posts = postsList.children;

  for (let i = 0; i < posts.length; i++) {
    const post = posts[i];
    if (i >= startIndex && i < endIndex) {
      post.style.display = 'table-row';
    } else {
      post.style.display = 'none';
    }
  }
}

function updatePagination() {
  const newTotalPosts = postsList.children.length;
  const newTotalPages = Math.ceil(newTotalPosts / postsPerPage);

  if (newTotalPages > totalPages) {
    for (let i = totalPages + 1; i <= newTotalPages; i++) {
      const pageButton = document.createElement('button');
      pageButton.classList.add('page-link');
      pageButton.textContent = i;
      pagination.appendChild(pageButton);
    }
  } else if (newTotalPages < totalPages) {
    const pageLinks = pagination.querySelectorAll('button');
    for (let i = totalPages - 1; i >= newTotalPages; i--) {
      const pageButton = pageLinks[i];
      pageButton.parentNode.removeChild(pageButton);
    }
  }

  totalPages = newTotalPages;
}

function setActivePage() {
  const pageLinks = pagination.querySelectorAll('button');
  for (let i = 0; i < pageLinks.length; i++) {
    const pageButton = pageLinks[i];
    const pageNumber = parseInt(pageButton.textContent);
    if (pageNumber === currentPage) {
      pageButton.classList.add('active');
    } else {
      pageButton.classList.remove('active');
    }
  }
}

function showActivePage(event) {
  const pageButton = event.target;
  const pageNumber = parseInt(pageButton.textContent);
  if (pageNumber !== currentPage) {
    currentPage = pageNumber;
    showPage(currentPage);
    setActivePage();
  }
}

pagination.addEventListener('click', showActivePage);

showPage(currentPage);
updatePagination();
setActivePage();