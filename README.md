# 🚀 How I Deployed My Java Application

This project outlines how I deployed a Java application using Docker, GitHub Actions, and Render. It was a fun learning experience, helping me improve my DevOps and deployment skills.

---

## 📁 Project Setup

1. First, I created the project folder and added the necessary files:

   ```bash
   mkdir Java-Concepts
   ```

   I then created the project structure ( `src/main/java/Main.java`).

2. Next, I initialized a Git repository and connected it to GitHub:

   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   git remote add origin https://.....
   ```

---

## 🐳 Docker Setup

3. I created a `Dockerfile` and a `docker-compose.yml` file to build and run my application in a containerized environment.

---

## 🔁 GitHub Actions (CI/CD)

4. I set up CI/CD automation by creating a GitHub Actions workflow file:

   ```
   .github/workflows/main.yml
   ```

   This workflow builds my app every time I push changes.

---

## ☁️ Deployment on Render

5. After pushing my code to the main branch, Render automatically picked up the changes and deployed the latest version of the app — similar to how webhooks work with Netlify or GitHub Pages.

---

## 💡 Final Thoughts

I had so much fun learning and using these tools. This project helped me practice containerization, automation, and modern deployment strategies.

---

## 🛠 Tech Stack

* **Java**
* **Docker**
* **GitHub Actions**
* **Render** (Hosting)
