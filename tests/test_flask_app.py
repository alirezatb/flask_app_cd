import sys
import os
import unittest
import app

class BasicsTests(unittest.TestCase):
    def setUp(self) -> None:
        self.app = app.app.test_client()

    def tearDown(self) -> None:
        pass

    def test_main_page(self):
        response = self.app.get("/", follow_redirects=True)
        self.assertEqual(response.status_code, 200)
if __name__=="__main__":
    unittest.main()
