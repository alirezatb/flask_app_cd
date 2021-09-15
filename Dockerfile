FROM alpine:3.7

RUN apk add --ipdate python3

COPY requirements.txt /usr/src/app/
COPY app.py /usr/src/app/
COPY templates/index.html /usr/src/app/templates/

RUN pip3 install --no-cache-dir -r /usr/src/app/requirements.txt

EXPOSE 5000

CMD ["python3", "/usr/src/app/app.py"]