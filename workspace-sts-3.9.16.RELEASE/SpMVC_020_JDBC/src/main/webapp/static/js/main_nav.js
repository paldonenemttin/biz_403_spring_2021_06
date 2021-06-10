document.addEventListener("DOMContentLoaded", () => {
  const nav = document.querySelector("nav#main_nav");

  nav.addEventListener("click", (e) => {
    let tagName = e.target.tagName;
    // `` backTit : 작은 역따옴표
    // js에서 변수를 포함하는 문자열을 생성할때 사용한다
    let urlPath = `${rootPath}`;
    if (tagName === "LI") {
      let menuText = e.target.textContent;
      if (menuText === "HOME") {
        urlPath += `/`;
      } else if (menuText === "도서정보") {
        urlPath += `/books`;
      } else if (menuText === "출판사정보") {
        urlPath += `/comp`;
      } else if (menuText === "저자정보") {
        urlPath += `/author`;
      } else if (menuText === "로그인") {
        urlPath += `/member/login`;
      } else if (menuText === "회원가입") {
        urlPath += `/member/join`;
      }
      location.href = urlPath;
    }
  });
});
