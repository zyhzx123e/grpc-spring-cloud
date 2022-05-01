@echo off
for %%i in (proto/*.proto) do (
  E:/proj/grpcv_jb51/grpc-spring-api/src/main/resources/tools/protoc.exe --plugin=protoc-gen-grpc-java=E:/proj/grpcv_jb51/grpc-spring-api/src/main/resources/tools/protoc-grpc.exe --java_out=../java --grpc-java_out=../java ./proto/%%i
  echo generate %%i to java file successfully!
)

