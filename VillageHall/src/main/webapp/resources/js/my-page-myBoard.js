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

// 페이징용 js

// 페이지 버튼 생성
function generatePageButtons(totalPages, currentPage) {
  let startPage, endPage;
  if (totalPages <= 5) { // 1,2,3,4,5 페이지(적으면 그만큼만)
    startPage = 1;
    endPage = totalPages;
  } else {
    if (currentPage <= 3) { // 1,2,3페이지일경우
      startPage = 1;
      endPage = 5;
    } else if (currentPage + 1 >= totalPages) { // 현재페이지가 마지막 페이지일경우
      startPage = totalPages - 4;
      endPage = totalPages;
    } else { // 그냥 중간이면 앞뒤로 2페이지씩
      startPage = currentPage - 2;
      endPage = currentPage + 2; 
    }
  }

  let pageButtons = '';
  for (let i = startPage; i <= endPage; i++) {
    if (i == currentPage) {
      pageButtons += `<button class="active">${i}</button>`;
    } else {
      pageButtons += `<button onclick="goToPage(${i})">${i}</button>`;
    }
  }
  document.getElementById('pagination').innerHTML = pageButtons;
}

// 총 게시글 갯수
const content = document.getElementById("content");
let totalContentCount = content.rows.length;

// 한페이지당 제한 게시글 수
const contentPerPage = 10;

// 총페이지 갯수
let totalPages = Math.ceil(totalContentCount / contentPerPage);

// 현재 페이지 그룹 계산
const maxPageButton = 5; 

// 현재페이지 (시작 = 1)
let page = 1;