**📚 README.md for Beginners - Spring Boot with Maven**

```markdown
# 🚀 Learn Spring Boot - Beginner's Guide

> **Spring Boot learning project using Maven for beginners**

## 📋 Table of Contents
- [System Requirements](#-system-requirements)
- [Installation & Setup](#-installation--setup)
- [How to Run the Application](#-how-to-run-the-application)
- [Automated Scripts](#-automated-scripts)
- [Development Workflow](#-development-workflow)
- [Testing](#-testing)
- [Build & Deploy](#-build--deploy)
- [Troubleshooting](#-troubleshooting)
- [Tips & Tricks](#-tips--tricks)

## 🔧 System Requirements

### Prerequisites:
- ✅ **Java 21** (already installed via SDKMAN)
- ✅ **Maven** (or use Maven Wrapper)
- ✅ **Git** 
- ✅ **VS Code** (optional, but recommended)

### Check Installation:
```bash
# Check Java version
java -version

# Check Maven (optional, we use wrapper)
mvn -version

# Check Git
git --version
```

## 📦 Installation & Setup

### 1. Clone/Download Project
```bash
# If from Git
git clone <repository-url>
cd learn-spring

# Or if already exists
cd ~/workspace/learn/learn-spring
```

### 2. Setup Maven Wrapper (Automatic)
```bash
# Maven wrapper is provided, ready to use
./mvnw --version
```

## 🚀 How to Run the Application

### 🎯 Fastest Way (Beginners):
```bash
# Navigate to project folder
cd ~/workspace/learn/learn-spring

# Run the application
./mvnw spring-boot:run
```

### 📱 Access Application:
- **URL**: http://localhost:8080
- **Health Check**: http://localhost:8080/actuator/health
- **Stop**: Press `Ctrl + C` in terminal

## 🛠️ Automated Scripts

### 📝 Create Helper Scripts

#### 1. **run.sh** - Run Application
```bash
#!/bin/bash
# File: run.sh

echo "🚀 Starting Spring Boot Application..."
echo "📁 Project: $(basename $(pwd))"
echo "☕ Java: $(java -version 2>&1 | head -n 1 | cut -d'"' -f2)"
echo "📦 Maven: $(./mvnw --version | head -n 1)"
echo ""

echo "🔄 Starting application..."
echo "🌐 Will be available at: http://localhost:8080"
echo "⏹️  Press Ctrl+C to stop"
echo ""

./mvnw spring-boot:run
```

#### 2. **dev.sh** - Development Mode
```bash
#!/bin/bash
# File: dev.sh

echo "🔧 Starting in DEVELOPMENT mode..."
echo "📋 Features:"
echo "   - Hot reload enabled"
echo "   - Debug logging"
echo "   - Dev profile active"
echo ""

./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

#### 3. **build.sh** - Build Project
```bash
#!/bin/bash
# File: build.sh

echo "🔨 Building Spring Boot Application..."
echo ""

# Clean previous build
echo "🧹 Cleaning previous build..."
./mvnw clean

# Compile and package
echo "📦 Compiling and packaging..."
./mvnw package -DskipTests

# Check if build successful
if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Build successful!"
    echo "📁 JAR file created in: target/"
    ls -la target/*.jar
    echo ""
    echo "🚀 To run: java -jar target/*.jar"
else
    echo ""
    echo "❌ Build failed!"
    exit 1
fi
```

#### 4. **test.sh** - Run Tests
```bash
#!/bin/bash
# File: test.sh

echo "🧪 Running Tests..."
echo ""

./mvnw test

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ All tests passed!"
else
    echo ""
    echo "❌ Some tests failed!"
    exit 1
fi
```

#### 5. **setup.sh** - Initial Setup
```bash
#!/bin/bash
# File: setup.sh

echo "⚙️  Setting up Spring Boot project..."
echo ""

# Make scripts executable
echo "🔧 Making scripts executable..."
chmod +x run.sh dev.sh build.sh test.sh clean.sh

# Download dependencies
echo "📦 Downloading dependencies..."
./mvnw dependency:resolve

# Compile project
echo "🔨 Initial compilation..."
./mvnw compile

echo ""
echo "✅ Setup complete!"
echo ""
echo "📋 Available commands:"
echo "   ./run.sh     - Run application"
echo "   ./dev.sh     - Run in development mode"  
echo "   ./build.sh   - Build JAR file"
echo "   ./test.sh    - Run tests"
echo "   ./clean.sh   - Clean project"
```

#### 6. **clean.sh** - Clean Project
```bash
#!/bin/bash
# File: clean.sh

echo "🧹 Cleaning project..."
echo ""

# Maven clean
./mvnw clean

# Remove logs
rm -f *.log
rm -f logs/*.log 2>/dev/null

# Remove temp files
rm -rf .tmp/
rm -f nohup.out

echo "✅ Project cleaned!"
```

### 🎯 Create All Scripts at Once:
```bash
# Run in project folder
cd ~/workspace/learn/learn-spring

# Create script generator
cat > create-scripts.sh << 'EOF'
#!/bin/bash

echo "📝 Creating Spring Boot helper scripts..."

# Create run.sh
cat > run.sh << 'SCRIPT'
#!/bin/bash
echo "🚀 Starting Spring Boot Application..."
echo "📁 Project: $(basename $(pwd))"
echo "☕ Java: $(java -version 2>&1 | head -n 1 | cut -d'"' -f2)"
echo ""
echo "🔄 Starting application..."
echo "🌐 Will be available at: http://localhost:8080"
echo "⏹️  Press Ctrl+C to stop"
echo ""
./mvnw spring-boot:run
SCRIPT

# Create dev.sh  
cat > dev.sh << 'SCRIPT'
#!/bin/bash
echo "🔧 Starting in DEVELOPMENT mode..."
echo "📋 Features: Hot reload, Debug logging, Dev profile"
echo ""
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
SCRIPT

# Create build.sh
cat > build.sh << 'SCRIPT'
#!/bin/bash
echo "🔨 Building Spring Boot Application..."
echo ""
echo "🧹 Cleaning..."
./mvnw clean
echo "📦 Building..."
./mvnw package -DskipTests
if [ $? -eq 0 ]; then
    echo "✅ Build successful!"
    ls -la target/*.jar
else
    echo "❌ Build failed!"
    exit 1
fi
SCRIPT

# Create test.sh
cat > test.sh << 'SCRIPT'
#!/bin/bash
echo "🧪 Running Tests..."
./mvnw test
SCRIPT

# Create clean.sh
cat > clean.sh << 'SCRIPT'
#!/bin/bash
echo "🧹 Cleaning project..."
./mvnw clean
rm -f *.log nohup.out
echo "✅ Cleaned!"
SCRIPT

# Make all executable
chmod +x *.sh

echo "✅ All scripts created!"
echo ""
echo "📋 Available commands:"
echo "   ./run.sh     - Run application"
echo "   ./dev.sh     - Development mode"
echo "   ./build.sh   - Build project"
echo "   ./test.sh    - Run tests"
echo "   ./clean.sh   - Clean project"
EOF

# Run script generator
chmod +x create-scripts.sh
./create-scripts.sh
```

## 🔄 Development Workflow

### 📅 Daily Workflow:
```bash
# 1. Open terminal, navigate to project
cd ~/workspace/learn/learn-spring

# 2. Pull latest changes (if any)
git pull

# 3. Run application
./run.sh

# 4. Open browser: http://localhost:8080

# 5. Edit code in VS Code

# 6. Test changes (restart app if needed)

# 7. Run tests
./test.sh

# 8. Commit changes
git add .
git commit -m "Add new feature"
git push
```

### 🔧 Development Mode:
```bash
# Run with auto-reload
./dev.sh

# Or manual
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## 🧪 Testing

### Run All Tests:
```bash
./test.sh

# Or manual
./mvnw test
```

### Run Specific Test:
```bash
./mvnw test -Dtest=LearnSpringApplicationTests
```

### Run Tests with Coverage:
```bash
./mvnw test jacoco:report
```

## 🔨 Build & Deploy

### Build JAR File:
```bash
./build.sh

# Or manual
./mvnw clean package
```

### Run JAR File:
```bash
# After building
java -jar target/learn-spring-*.jar

# With profile
java -jar target/learn-spring-*.jar --spring.profiles.active=prod

# With custom port
java -jar target/learn-spring-*.jar --server.port=8081
```

### Background Process:
```bash
# Run in background
nohup java -jar target/learn-spring-*.jar > app.log 2>&1 &

# Check process
ps aux | grep java

# Stop process
pkill -f "learn-spring"
```

## 🚨 Troubleshooting

### Common Issues:

#### 1. **Port Already in Use**
```bash
# Find process using port 8080
lsof -i :8080

# Kill process
kill -9 <PID>

# Or run on different port
./mvnw spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

#### 2. **Maven Wrapper Not Found**
```bash
# Generate Maven wrapper
mvn wrapper:wrapper

# Or download manually
curl -o mvnw https://repo1.maven.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper-3.2.0.jar
```

#### 3. **Java Version Issues**
```bash
# Check Java version
java -version

# Switch Java version (if using SDKMAN)
sdk use java 21.0.7-amzn
```

#### 4. **Permission Denied**
```bash
# Make scripts executable
chmod +x *.sh

# Make Maven wrapper executable
chmod +x mvnw
```

### Debug Commands:
```bash
# Check project structure
ls -la

# Check dependencies
./mvnw dependency:tree

# Check plugins
./mvnw help:effective-pom

# Verbose output
./mvnw spring-boot:run -X
```

## 💡 Tips & Tricks

### 🚀 Quick Commands:
```bash
# Create aliases in ~/.zshrc or ~/.bashrc
alias sb-run='./mvnw spring-boot:run'
alias sb-dev='./mvnw spring-boot:run -Dspring-boot.run.profiles=dev'
alias sb-build='./mvnw clean package'
alias sb-test='./mvnw test'
alias sb-clean='./mvnw clean'

# Reload shell
source ~/.zshrc
```

### 🔧 Environment Variables:
```bash
# Set environment variables
export SPRING_PROFILES_ACTIVE=dev
export SERVER_PORT=8081
export JAVA_OPTS="-Xmx512m"

# Or create .env file
cat > .env << EOF
SPRING_PROFILES_ACTIVE=dev
SERVER_PORT=8081
DATABASE_URL=jdbc:h2:mem:testdb
EOF
```

### 📊 Monitoring:
```bash
# Health check
curl http://localhost:8080/actuator/health

# Application info
curl http://localhost:8080/actuator/info

# Metrics
curl http://localhost:8080/actuator/metrics
```

### 🎯 IDE Integration:
```bash
# Generate IDE files
./mvnw idea:idea          # IntelliJ IDEA
./mvnw eclipse:eclipse    # Eclipse

# Import in VS Code
# Just open folder in VS Code with Java extensions
```

## 📚 Learning Resources

### 📖 Documentation:
- [Spring Boot Official Docs](https://spring.io/projects/spring-boot)
- [Maven Official Docs](https://maven.apache.org/guides/)
- [Spring Boot Guides](https://spring.io/guides)

### 🎓 Tutorials:
- [Spring Boot Tutorial](https://www.baeldung.com/spring-boot)
- [Maven Tutorial](https://www.baeldung.com/maven)

## 🤝 Contributing

### Development Setup:
```bash
# Fork the repository
# Clone your fork
git clone <your-fork-url>
cd learn-spring

# Create feature branch
git checkout -b feature/new-feature

# Make changes
# Test changes
./test.sh

# Commit and push
git add .
git commit -m "Add new feature"
git push origin feature/new-feature

# Create pull request
```

## 📝 Project Structure

```
learn-spring/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/learn_spring/
│   │   │       └── LearnSpringApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-dev.properties
│   └── test/
│       └── java/
│           └── com/example/learn_spring/
│               └── LearnSpringApplicationTests.java
├── target/                 # Build output
├── pom.xml                # Maven configuration
├── mvnw                   # Maven wrapper (Unix)
├── mvnw.cmd              # Maven wrapper (Windows)
├── .mvn/                 # Maven wrapper config
├── run.sh                # Run application
├── dev.sh                # Development mode
├── build.sh              # Build project
├── test.sh               # Run tests
├── clean.sh              # Clean project
└── README.md             # This file
```

## 🎉 Quick Start

```bash
# 1. Navigate to project
cd ~/workspace/learn/learn-spring

# 2. Create helper scripts
curl -sSL https://raw.githubusercontent.com/example/scripts/main/create-scripts.sh | bash

# 3. Run application
./run.sh

# 4. Open browser
open http://localhost:8080
```

---

**Happy Coding! 🚀**

> **Need help?** Check the [Troubleshooting](#-troubleshooting) section or create an issue.
```

## 🎯 Quick Setup Command

```bash
# Create README.md in your project
cd ~/workspace/learn/learn-spring

# Download this README
curl -o README.md https://raw.githubusercontent.com/example/readme/main/README.md

# Or create manually
cat > README.md << 'EOF'
[paste the content above]
EOF

echo "✅ README.md created!"
```

This README provides:
- ✅ **Complete beginner guide** in English
- ✅ **Step-by-step instructions**
- ✅ **Automated scripts** for common tasks
- ✅ **Troubleshooting section**
- ✅ **Best practices** and tips
- ✅ **Project structure** explanation
- ✅ **Quick start** commands

**Ready to use!** 🚀