// Attach event listeners to each <div> with class "code-container"
const codeContainers = document.querySelectorAll('.code-container');
codeContainers.forEach(container => {
  container.addEventListener('mouseenter', startTypingAnimation);
});

// Variables to store scroll positions
let lastKnownScrollPosition = 0;
let ticking = false;

// Start typing animation when a <div> is entered
function startTypingAnimation(event) {
  const container = event.target;
  const codeElement = container.querySelector('code');
  const filePath = codeElement.getAttribute('data-file');

  // Pause animation when scrolling up
  window.addEventListener('scroll', function(e) {
    lastKnownScrollPosition = window.scrollY;

    if (!ticking) {
      window.requestAnimationFrame(function() {
        checkScrollPosition(codeElement);
        ticking = false;
      });

      ticking = true;
    }
  });

  fetchFile(filePath)
    .then(data => {
      animateTyping(codeElement, data);
      container.removeEventListener('mouseenter', startTypingAnimation);
    })
    .catch(error => {
      console.error('Error:', error);
    });
}

// Check scroll position and pause/resume animation accordingly
function checkScrollPosition(element) {
  const elementTop = element.getBoundingClientRect().top;

  if (elementTop < window.innerHeight && elementTop >= 0) {
    // Resume animation if element is in view
    animateTyping(element, element.dataset.text);
  } else {
    // Pause animation if element is out of view
    pauseTypingAnimation(element);
  }
}

// Pause typing animation
function pauseTypingAnimation(element) {
  element.style.animationPlayState = 'paused';
}

// Resume typing animation
function resumeTypingAnimation(element) {
  element.style.animationPlayState = 'running';
}

// Simulate typing animation
function animateTyping(element, text) {
  element.textContent = ''; // Clear existing text
  const delay = 10; // Delay between each character (in milliseconds)
  let index = 0;
  let code = '';

  function typeNextCharacter() {
    if (index < text.length) {
      code += text.charAt(index);
      element.textContent = code;
      index++;
      setTimeout(typeNextCharacter, delay);
    }
  }

  typeNextCharacter();

  // Resume animation on start or when scrolled back into view
  resumeTypingAnimation(element);
}

// Fetch a file and return its content
function fetchFile(filePath) {
  return fetch(filePath)
    .then(response => response.text());
}